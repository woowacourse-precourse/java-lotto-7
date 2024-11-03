package lotto.model;

import java.util.Map;

public class Result {
    private final Map<Rank, Integer> matchCount;
    private final double profitRate;

    public Result(Map<Rank, Integer> matchCount, double profitRate){
        this.matchCount = matchCount;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getMatchCount() {
        return matchCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
