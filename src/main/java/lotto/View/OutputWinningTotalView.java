package lotto.View;

import lotto.Enum.PrintConstants;
import lotto.Enum.WinningPrize;

import java.util.Map;

public class OutputWinningTotalView {
    private final Map<String, Integer> resultMap;

    public OutputWinningTotalView(Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public void printWinningTotal() {
        System.out.println("\n");
        System.out.println(PrintConstants.ALERT_WINNING_TOTAL.getMessage());
        System.out.println(PrintConstants.SEPARATE_LINE.getMessage());

        for(WinningPrize prize : WinningPrize.values()) {
            System.out.println(String.format(prize.getMessage(),resultMap.get(prize.toString())));
        }

        System.out.println(PrintConstants.SEPARATE_LINE.getMessage());

    }
}
