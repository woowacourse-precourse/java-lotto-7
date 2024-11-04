package lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain;

import java.util.Map;

public class LottoResult {

    private Map<Integer,Integer> rank;
    private float roi;

    public LottoResult(Map<Integer,Integer> rank, float roi) {
        this.rank = rank;
        this.roi = roi;
    }

    public Map<Integer,Integer> getRank(){
        return rank;
    }

    public float getRoi(){
        return roi;
    }

}
