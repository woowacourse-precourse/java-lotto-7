package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCnt;
    private final int purchaseAmount;

    public LottoResult(int purchaseAmount){
        this.rankCnt = new EnumMap<>(LottoRank.class);
        this.purchaseAmount = purchaseAmount;
    }
}
