package lotto.domain;

import java.util.Map;

public class ProfitCalculator {
    private static final int PERCENT_CONVERSION_FACTOR = 100;
    private final Money totalSpent;
    private final PrizeResult prizeResult;

    public ProfitCalculator(Money totalSpent, PrizeResult prizeResult) {
        this.totalSpent = totalSpent;
        this.prizeResult = prizeResult;
    }

    public double calculateProfitRatio() {
        long totalPrize = calculateTotalPrize();
        return ((double) totalPrize / totalSpent.getMoney()) * PERCENT_CONVERSION_FACTOR;
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Prize, Integer> entry : prizeResult.getPrizeCount().entrySet()) {
            Prize prize = entry.getKey();
            Integer count = entry.getValue();

            totalPrize += prize.getPrize() * count;
        }
        return totalPrize;
    }
}
