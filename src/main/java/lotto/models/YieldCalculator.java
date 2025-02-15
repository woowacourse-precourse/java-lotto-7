package lotto.models;

import lotto.utils.Prize;

public class YieldCalculator {
    private final Statistics statistics;

    public YieldCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public double calculateYield(int totalPurchaseAmount) {
        int totalWinningAmount = 0;

        for (Prize prize : Prize.values()) {
            int count = statistics.getCount(prize);
            totalWinningAmount += count * prize.getMatchAmount();
        }

        return (totalWinningAmount / (double) totalPurchaseAmount) * 100;
    }

}
