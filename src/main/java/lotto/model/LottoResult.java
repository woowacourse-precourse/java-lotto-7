package lotto.model;

import java.util.HashMap;

public class LottoResult {
    private HashMap<Rank, Integer> lottoResultMap;

    public LottoResult(HashMap<Rank, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public HashMap<Rank, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

}
