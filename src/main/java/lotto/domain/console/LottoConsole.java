package lotto.domain.console;

import lotto.domain.console.util.CommandReader;
import lotto.domain.console.util.CommandWriter;
import lotto.domain.lotto.dto.request.LottoGameReq;
import lotto.domain.lotto.presentation.LottoController;
import lotto.domain.lotto.service.LottoService;

import java.util.Arrays;
import java.util.List;

public class LottoConsole {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";

    private final LottoController controller;

    public LottoConsole(LottoService lottoService) {
        this.controller = new LottoController(lottoService);
    }

    public void run() {
        int amount = inputPurchaseAmount();
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();

        LottoGameReq request = LottoGameReq.of(amount, winningNumbers, bonusNumber);
        controller.createAndPlayGame(request);

        printResults();
    }

    private int inputPurchaseAmount() {
        CommandWriter.write(PURCHASE_AMOUNT_MESSAGE);
        int amount = Integer.parseInt(CommandReader.read());
        CommandWriter.write(String.format(PURCHASE_RESULT_MESSAGE, amount / 1000));
        return amount;
    }

    private List<Integer> inputWinningNumbers() {
        CommandWriter.write(WINNING_NUMBERS_MESSAGE);
        return Arrays.stream(CommandReader.read().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private int inputBonusNumber() {
        CommandWriter.write(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(CommandReader.read());
    }

    private void printResults() {
        CommandWriter.write(WINNING_STATISTICS_MESSAGE);

        var gameResult = controller.getGameResult();
        gameResult.getResults().forEach(result ->
                CommandWriter.write(result.getResultMessage())
        );

        CommandWriter.write(String.format("\n총 수익률은 %.1f%%입니다.", gameResult.getProfitRate()));
    }
}