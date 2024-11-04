package lotto.view;

import lotto.domain.LottoWinningTable;

import java.util.Map;
import java.util.Set;

public class OutView {
    public static final String RESULT_DISPLAY_FORMAT = "%s - %d개\n";
    private static final String PROFIT_PRINT_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    public static void showWinningResult(final Map<LottoWinningTable, Integer> winningResultTable,final long purchasePrice) {
        Set<Map.Entry<LottoWinningTable, Integer>> entries = winningResultTable.entrySet();
        for (LottoWinningTable table : LottoWinningTable.values()) {
            System.out.printf(RESULT_DISPLAY_FORMAT, table.toString(), winningResultTable.get(table));
        }
        System.out.printf(PROFIT_PRINT_FORMAT, turnIntoPercent((float) calculateProfit(entries)/ purchasePrice));
    }
    private static long calculateProfit(final Set<Map.Entry<LottoWinningTable, Integer>> entries) {
        long result = 0;
        for (Map.Entry<LottoWinningTable, Integer> entry : entries) {
            long diff = (long) entry.getKey().getReward() * entry.getValue();
            result += diff;
        }
        return result;
    }

    private static double turnIntoPercent(double profitRatio) {
        return Math.round(profitRatio * 1000) / 10.0;
    }
}
