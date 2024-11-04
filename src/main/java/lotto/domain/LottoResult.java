package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;
    private final double totalProfitRate;
    private final long totalPrize;

    public LottoResult(Map<LottoRank, Integer> rankCounts, double totalProfitRate, long totalPrize) {
        this.rankCounts = rankCounts;
        this.totalProfitRate = totalProfitRate;
        this.totalPrize = totalPrize;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return totalProfitRate;
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}
