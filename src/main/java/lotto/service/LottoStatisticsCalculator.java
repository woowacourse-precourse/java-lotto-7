package lotto.service;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsCalculator {

    private LottoStatisticsCalculator() {
    }

    public static Map<LottoRank, Long> calculateRankCounts(List<LottoResult> results) {
        Map<LottoRank, Long> rankCounts = new HashMap<>();
        for (LottoResult result : results) {
            LottoRank rank = LottoRank.findByMatchAndBonus(result.getMatchCount(), result.isBonusMatched());
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0L) + 1);
        }
        return rankCounts;
    }

    public static double calculateProfitRate(Map<LottoRank, Long> rankCounts, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(rankCounts);
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 100.0) / 100.0;
    }

    private static long calculateTotalPrize(Map<LottoRank, Long> rankCounts) {
        long totalPrize = 0;
        for (Map.Entry<LottoRank, Long> entry : rankCounts.entrySet()) {
            totalPrize += (entry.getValue() * entry.getKey().getPrize());
        }
        return totalPrize;
    }
}
