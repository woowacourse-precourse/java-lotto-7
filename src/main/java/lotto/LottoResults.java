package lotto;

import java.util.Map;

public class LottoResults {
    private final Map<Rank, Integer> rankFrequency;
    private final double revenue;

    public LottoResults(Map<Rank, Integer> rankFrequency, double revenue) {
        this.rankFrequency = rankFrequency;
        this.revenue = revenue;
    }

    public double getRevenue() {
        return revenue;
    }

    public Map<Rank, Integer> getRankFrequency() {
        return rankFrequency;
    }
}
