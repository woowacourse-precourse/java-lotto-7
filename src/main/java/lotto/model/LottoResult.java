package lotto.model;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> rankResults;
    private final double profitRate;

    public LottoResult(Map<Integer, Integer> rankResults, double profitRate) {
        this.rankResults = rankResults;
        this.profitRate = profitRate;
    }

    public Map<Integer, Integer> getRankResults() {
        return rankResults;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
