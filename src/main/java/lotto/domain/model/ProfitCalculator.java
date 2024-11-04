package lotto.domain.model;

import java.util.Map;

public class ProfitCalculator {

    public static double calculateProfitRate(Map<LottoRank, Integer> results, int amountSpent) {
        double totalProfit = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (totalProfit / amountSpent) * 100;
    }
}