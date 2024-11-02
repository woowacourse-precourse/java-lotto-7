package lotto.View;

import lotto.Enum.WinningPrize;

import java.util.Map;

import static lotto.Utils.PrintConstants.ALERT_WINNING_TOTAL;
import static lotto.Utils.PrintConstants.SEPARATE_LINE;

public class OutputWinningTotalView {
    private final Map<String, Integer> resultMap;

    public OutputWinningTotalView(Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public void printWinningTotal() {
        System.out.println("\n");
        System.out.println(ALERT_WINNING_TOTAL);
        System.out.println(SEPARATE_LINE);

        for (WinningPrize prize : WinningPrize.values()) {
            System.out.printf((prize.getMessage()) + "%n", resultMap.get(prize.toString()));
        }

        System.out.println(SEPARATE_LINE);

    }
}
