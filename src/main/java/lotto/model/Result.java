package lotto.model;

import java.util.Map;

public class Result {
    private final Map<Rank, Integer> matchCount;
    private final double profitRate;
    private final int totalPrize;

    public Result(Map<Rank, Integer> matchCount, double profitRate, int totalPrize) {
        this.matchCount = matchCount;
        this.profitRate = profitRate;
        this.totalPrize = totalPrize;
    }

    public Map<Rank, Integer> getMatchCount() {
        return matchCount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
