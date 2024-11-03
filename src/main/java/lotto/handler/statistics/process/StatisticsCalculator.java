package lotto.handler.statistics.process;

import java.util.HashMap;
import java.util.Map;
import lotto.display.DisplayFormat;
import lotto.handler.purchase.process.WinningRank;

public class StatisticsCalculator {
    public String calculate(HashMap<WinningRank, Integer> rankCounts, double purchaseAmount) {
        double totalPrize = 0;
        for (Map.Entry<WinningRank, Integer> rankCount : rankCounts.entrySet()) {
            totalPrize += rankCount.getKey().getWinningAmount() * rankCount.getValue();
        }
        return getProfitRate(totalPrize, purchaseAmount);
    }

    private String getProfitRate(double totalPrize, double purchaseAmount) {
        return String.format(DisplayFormat.PROFIT_RATE_FORMAT.displayDefault(), (totalPrize / purchaseAmount) * 100);
    }
}
