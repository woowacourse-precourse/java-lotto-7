package lotto.model;

import java.util.HashMap;

public class LottosResult {
    private final HashMap<LottoRank, Integer> lottosResult;

    public LottosResult() {
        lottosResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.getAllLottoRank()) {
            lottosResult.put(lottoRank, 0);
        }
    }

    public Integer get(LottoRank lottoRank) {
        return lottosResult.get(lottoRank);
    }

    public void plus(LottoRank lottoRank) {
        lottosResult.put(lottoRank, get(lottoRank) + 1);
    }
}
