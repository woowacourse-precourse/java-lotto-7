package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> ranks;
    private final double profitRate;

    public LottoResult(Map<Integer, Integer> ranks, double profitRate) {
        this.ranks = ranks;
        this.profitRate = profitRate;
    }

    public Map<Integer, Integer> getRanks() {
        return ranks;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
