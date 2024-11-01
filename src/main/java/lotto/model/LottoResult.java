package lotto.model;

import java.util.HashMap;

public class LottoResult {
    private HashMap<Rank, Integer> lottoResultMap;
    private int totalPrize;

    public LottoResult(HashMap<Rank, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
        this.totalPrize = 0;
    }

    public HashMap<Rank, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

    public int getTotalPrize() {
        for(Rank rank : Rank.values()){
            totalPrize += rank.getPrize() * lottoResultMap.get(rank);
        }

        return totalPrize;
    }
}
