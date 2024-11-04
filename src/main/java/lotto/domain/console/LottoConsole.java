package lotto.domain.console;

import java.util.stream.Collectors;
import lotto.domain.console.util.CommandReader;
import lotto.domain.console.util.CommandWriter;
import lotto.domain.lotto.presentation.LottoController;
import lotto.domain.lotto.service.LottoService;
import java.util.List;
import lotto.global.validator.InputValidator;


public class LottoConsole {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "\n총 수익률은 %.1f%%입니다.";

    private final LottoController controller = LottoController.getInstance(LottoService.getInstance());

    public void run() {
        try {
            processGame();
        } catch (IllegalArgumentException e) {
            CommandWriter.write(e.getMessage());
        }
    }

    private void processGame() {
        // 구매 금액 입력 및 로또 구매
        int amount = inputPurchaseAmount();
        List<List<Integer>> purchasedLottos = controller.purchaseLottos(amount);
        printPurchasedLottos(amount, purchasedLottos);

        // 당첨 번호 및 보너스 번호 입력
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        // 게임 실행 및 결과 출력
        controller.playGame(purchasedLottos, winningNumbers, bonusNumber);
        printResults();
    }

    private int inputPurchaseAmount() {
        CommandWriter.write(PURCHASE_AMOUNT_MESSAGE);
        return InputValidator.validatePurchaseAmount(CommandReader.read());
    }

    private List<Integer> inputWinningNumbers() {
        CommandWriter.write(WINNING_NUMBERS_MESSAGE);
        return InputValidator.validateWinningNumbers(CommandReader.read());
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        CommandWriter.write(BONUS_NUMBER_MESSAGE);
        return InputValidator.validateBonusNumber(CommandReader.read(), winningNumbers);
    }

    private void printPurchasedLottos(int amount, List<List<Integer>> purchasedLottos) {
        CommandWriter.writeFormat(PURCHASE_RESULT_MESSAGE, amount / 1000);
        purchasedLottos.forEach(lotto -> 
                CommandWriter.write(formatLottoNumbers(lotto))
        );
    }

    private String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private void printResults() {
        CommandWriter.write(WINNING_STATISTICS_MESSAGE);
        var gameResult = controller.getGameResult();
        gameResult.getResults().forEach(result ->
                CommandWriter.write(result.getResultMessage())
        );
        CommandWriter.writeFormat(PROFIT_RATE_MESSAGE, gameResult.getProfitRate());
    }
}