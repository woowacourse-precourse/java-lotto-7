package lotto.domain;

import lotto.util.Rank;

import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> ranks;
    private final double profitRate;

    public LottoResult(Map<Rank, Integer> ranks, double profitRate) {
        this.ranks = ranks;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public int getPrizeCount(Rank rank) {
        return ranks.getOrDefault(rank, 0);
    }
}
