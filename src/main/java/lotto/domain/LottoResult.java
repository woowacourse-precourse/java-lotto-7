package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> lottoResult = new HashMap<>();
    private double rate;

    public LottoResult(Map<LottoRank, Integer> lottoResult, double rate) {
        this.lottoResult = lottoResult; // lottoResult에 final을 붙이면 안되는 이유
        this.rate = rate;
    }

    public void init(){
        for(LottoRank lottoRank : LottoRank.values()){
            lottoResult.put(lottoRank, 0);
        }
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
