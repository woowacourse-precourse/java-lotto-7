package lotto.View;

import lotto.Enum.WinningPrize;

import java.util.Map;

import static lotto.Utils.PrintConstants.ALERT_WINNING_TOTAL;
import static lotto.Utils.PrintConstants.SEPARATE_LINE;

public class OutputWinningTotalView {
    public void printWinningTotal(Map<String, Integer> resultMap) {
        System.out.println("\n");
        System.out.println(ALERT_WINNING_TOTAL);
        System.out.println(SEPARATE_LINE);

        for (WinningPrize prize : WinningPrize.values()) {
            System.out.printf((prize.getMessage()) + "%n", resultMap.get(prize.toString()));
        }

        System.out.println(SEPARATE_LINE);

    }
}
