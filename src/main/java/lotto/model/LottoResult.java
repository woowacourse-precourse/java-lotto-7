package lotto.model;

import java.util.Map;
import lotto.constant.LottoRank;

public class LottoResult {
    private Map<LottoRank, Integer> results;
    private Double earningRate;

    public LottoResult() {
    }

    public LottoResult(Map<LottoRank, Integer> results, Double earningRate) {
        this.results = results;
        this.earningRate = earningRate;
    }

    public Map<LottoRank, Integer> getResults() {
        return results;
    }

    public Double getEarningRate() {
        return earningRate;
    }

}
