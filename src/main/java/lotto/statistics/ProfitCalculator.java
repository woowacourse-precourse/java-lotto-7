package lotto.statistics;


import lotto.result.LottoRank;

import java.util.Map;

public class ProfitCalculator {

    public static double calculateProfitRate(Map<LottoRank, Integer> resultStatistics, int totalPurchaseAmount) {
        long totalPrize = resultStatistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = ((double) totalPrize / totalPurchaseAmount) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
