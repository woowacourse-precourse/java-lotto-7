package lotto.domain.model;

import java.util.Map;

public class ProfitCalculator {
    private static final int PERCENTAGE_MULTIPLIER = 100;

    public static double calculateProfitRate(Map<LottoRank, Integer> results, int amountSpent) {
        double totalProfit = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (totalProfit / amountSpent) * PERCENTAGE_MULTIPLIER;
    }
}