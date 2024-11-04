package lotto.domain.console;

import java.util.stream.Collectors;
import lotto.domain.console.util.CommandReader;
import lotto.domain.console.util.CommandWriter;
import lotto.domain.lotto.presentation.LottoController;
import lotto.domain.lotto.service.LottoService;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import lotto.global.exception.ErrorMessage;


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
            // 구매 금액 입력 및 로또 구매
            int amount = inputPurchaseAmount();
            List<List<Integer>> purchasedLottos = controller.purchaseLottos(amount);
            printPurchasedLottos(amount, purchasedLottos);

            // 당첨 번호 및 보너스 번호 입력
            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber();

            // 게임 실행
            controller.playGame(purchasedLottos, winningNumbers, bonusNumber);

            // 결과 출력
            printResults();
        } catch (IllegalArgumentException e) {
            CommandWriter.write(e.getMessage());
        }
    }

    private int inputPurchaseAmount() {
        CommandWriter.write(PURCHASE_AMOUNT_MESSAGE);
        String input = CommandReader.read();
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    private void validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount > 100000000) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_MAXIMUM.getMessage());
            }
            if (amount < 1000) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_MINIMUM.getMessage());
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_NOT_NUMBER.getMessage());
        }
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

    private List<Integer> inputWinningNumbers() {
        CommandWriter.write(WINNING_NUMBERS_MESSAGE);
        String input = CommandReader.read();
        return validateAndParseWinningNumbers(input);
    }

    private List<Integer> validateAndParseWinningNumbers(String input) {
        try {
            if (!input.contains(",")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
            }

            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(this::parseNumber)
                    .collect(Collectors.toList());

            validateWinningNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMBER.getMessage());
        }
    }

    private int inputBonusNumber() {
        CommandWriter.write(BONUS_NUMBER_MESSAGE);
        String input = CommandReader.read();
        return validateAndParseBonusNumber(input);
    }

    private int validateAndParseBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            validateBonusNumberDuplicate(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMBER.getMessage());
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_SIZE.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_DUPLICATE.getMessage());
        }
    }

    private void validateBonusNumberDuplicate(int bonusNumber) {
        List<Integer> winningNumbers = controller.getWinningNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMBER.getMessage());
        }
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