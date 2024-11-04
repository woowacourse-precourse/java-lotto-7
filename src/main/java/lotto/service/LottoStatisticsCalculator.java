package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.HashMap;
import java.util.Map;

public class LottoStatisticsCalculator {
    private static final long INITIALIZED_TOTAL_PRIZE = 0L;

    public LottoResult calculateStatistic(Map<Lotto, LottoRank> lottoRankResults, int buyAmount) {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        long totalPrize = INITIALIZED_TOTAL_PRIZE;

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        for (LottoRank rank : lottoRankResults.values()) {
            totalPrize += rank.getPrize();
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        double profitRate = calculateProfitRate(buyAmount, totalPrize);

        return new LottoResult(rankCounts, profitRate, totalPrize);
    }

    private double calculateProfitRate(int buyAmount, long totalPrize) {
        double profitRate = ((double) totalPrize / buyAmount) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }
}
