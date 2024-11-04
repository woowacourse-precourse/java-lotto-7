package lotto.winningResult;

import java.util.Map;
import java.util.Map.Entry;

public class RevenueRate {
    private final int buyingAmount;
    private final Map<WinningResultInfo, Long> winningResultStatistics;

    private RevenueRate(int buyingAmount, Map<WinningResultInfo, Long> winningResultStatistics) {
        this.buyingAmount = buyingAmount;
        this.winningResultStatistics = winningResultStatistics;
    }

    public static RevenueRate of(int buyingAmount, Map<WinningResultInfo, Long> winningResultStatistics) {
        return new RevenueRate(buyingAmount, winningResultStatistics);
    }

    public double getRevenueRate() {
        double revenue = 0d;

        for (Entry<WinningResultInfo, Long> entry : winningResultStatistics.entrySet()) {
            long winningAmount = entry.getKey().getWinningAmount();
            Long matchingCount = entry.getValue();

            revenue += winningAmount * matchingCount;
        }

        return (double) revenue / buyingAmount;
    }
}
