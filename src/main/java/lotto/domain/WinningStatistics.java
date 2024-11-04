package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.common.config.LottoRank;

public class WinningStatistics {
    private final Map<LottoRank, Integer> rankCounts;
    private long totalPrize;

    public WinningStatistics() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        initRankCount();
    }

    private void initRankCount() {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCounts.put(lottoRank, 0);
        }
    }

    public void putRankCount(MatchResult result) {
        if (result.getRank() == null) {
            return;
        }
        LottoRank rank = result.getRank();
        int currentCount = rankCounts.get(rank);
        int newCount = currentCount + 1;
        rankCounts.put(rank, newCount);
    }

    public double calculateProfitRate(int purchaseAmount) {
        calculateTotalPrize();
        return (double) totalPrize / purchaseAmount * 100;
    }

    private void calculateTotalPrize() {
        for (Entry<LottoRank, Integer> entry : rankCounts.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
    }

    public int getRankCount(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }
}
