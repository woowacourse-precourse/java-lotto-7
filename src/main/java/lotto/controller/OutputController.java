package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.io.ConsoleOutputHandler;
import lotto.io.OutputHandler;

public class OutputController {
    private final OutputHandler outputHandler;

    public OutputController(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void showLottoPrice() {
        outputHandler.showLottoPrice();
    }

    public void showLottoCount(int lottoCount) {
        outputHandler.showLottoCount(lottoCount);
    }

    public void showLottoList(List<Integer> numbers) {
        outputHandler.showLottoList(numbers);
    }

    public void showWinningNumbersMessage() {
        outputHandler.showWinningNumbersMessage();
    }

    public void showBonusNumberMessage() {
        outputHandler.showBonusNumberMessage();
    }

    public void showMatchResult(Map<String, Integer> matchResults, double profitRate) {
        outputHandler.showMatchResult(matchResults, profitRate);
    }
}
