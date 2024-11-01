package lotto.model;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private List<LottoRanking> lottoRankingSet;

    private int totalPrice;

    public LottoResult() {
        this.lottoRankingSet = Arrays.asList(LottoRanking.values());
        this.totalPrice = 0;
    }

    public List<LottoRanking> getLottoRankingSet() {
        return lottoRankingSet;
    }

}
