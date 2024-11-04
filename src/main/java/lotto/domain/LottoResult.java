package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

    public LottoResult() {
        lottoResultInitialize();
    }

    private void lottoResultInitialize() {
        for(LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank != LottoRank.MISS) result.put(lottoRank, 0);
        }
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int calculateProfit() {
        return result.entrySet()
            .stream()
            .filter(resultEntry -> resultEntry.getValue() != 0)
            .mapToInt(resultEntry -> resultEntry.getKey().getPrize() * resultEntry.getValue())
            .sum();
    }
}
