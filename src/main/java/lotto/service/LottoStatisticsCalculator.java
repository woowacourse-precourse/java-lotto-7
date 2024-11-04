package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.HashMap;
import java.util.Map;

public class LottoStatisticsCalculator {
    private static final long INITIALIZED_TOTAL_PRIZE = 0L;
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final int INITIAL_COUNT = 0;
    private static final int COUNT_INCREMENT = 1;

    public LottoResult calculateStatistic(Map<Lotto, LottoRank> lottoRankResults, long buyAmount) {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        long totalPrize = INITIALIZED_TOTAL_PRIZE;
        initializeRankCounts(rankCounts);

        for (LottoRank rank : lottoRankResults.values()) {
            totalPrize += rank.getPrize();
            rankCounts.put(rank, rankCounts.getOrDefault(rank, INITIAL_COUNT) + COUNT_INCREMENT);
        }
        double profitRate = calculateProfitRate(buyAmount, totalPrize);

        return new LottoResult(rankCounts, profitRate, totalPrize);
    }

    private void initializeRankCounts(Map<LottoRank, Integer> rankCounts) {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, INITIAL_COUNT);
        }
    }

    private double calculateProfitRate(long buyAmount, long totalPrize) {
        double profitRate = ((double) totalPrize / buyAmount) * PERCENTAGE_MULTIPLIER;
        return Math.round(profitRate * PERCENTAGE_MULTIPLIER) / 100.0;
    }
}
