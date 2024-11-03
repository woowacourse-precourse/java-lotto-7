package lotto.view;

import java.util.Map;
import lotto.service.CommonWinningStrategy;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWinningStatistics(Map<CommonWinningStrategy, Integer> winningCounts) {

    }

    public void printRateOfReturn(Map<CommonWinningStrategy, Integer> winningCounts, long numberOfLottery) {

    }
}
