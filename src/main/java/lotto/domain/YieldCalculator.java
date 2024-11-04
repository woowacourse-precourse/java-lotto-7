package lotto.domain;

import java.util.Map;

public class YieldCalculator {
    public double calculateYield(Map<Rank, Integer> results, int purchaseAmount) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double yield = (double) totalPrize / purchaseAmount * 100;
        return Math.round(yield * 10) / 10.0;
    }
}
