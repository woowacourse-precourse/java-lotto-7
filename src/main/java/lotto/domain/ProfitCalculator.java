package lotto.domain;

import java.util.Map;

public class ProfitCalculator {

    private static final double PERCENTAGE_MULTIPLIER = 100.0;

    public double calculateProfitRate(Map<LottoRank, Integer> rankCounts, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(rankCounts);
        return calculateRate(totalPrize, purchaseAmount);
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateRate(long totalPrize, int purchaseAmount) {
        double profitRate = (double) totalPrize / purchaseAmount * PERCENTAGE_MULTIPLIER;
        return Math.round(profitRate * 10) / 10.0;
    }
}
