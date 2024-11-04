package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public void addResult(LottoRank rank) {
        if(rank != null) lottoResult.put(rank, lottoResult.get(rank) + 1);
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

}
