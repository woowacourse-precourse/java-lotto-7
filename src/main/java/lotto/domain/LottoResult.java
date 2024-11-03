package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> result = new HashMap<>();
    private double rate;

    public LottoResult() {
        init();
    }

    public void init() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }
}
