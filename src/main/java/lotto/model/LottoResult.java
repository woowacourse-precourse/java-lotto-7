package lotto.model;

import lotto.constant.LottoRank;

public class LottoResult {
    private final LottoRank lottoRank;

    public LottoResult(LottoRank lottoRank) {
        this.lottoRank = lottoRank;
    }

    public String getLottoRank() {
        return lottoRank.getRank();
    }

    public int getWinnings() {
        return lottoRank.getPrizeMoney();
    }
}