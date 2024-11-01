package lotto.model;

import java.util.Map;

public class LottoWinningResult {

    private final Map<LottoRank, Integer> lottoWinningResult;

    private LottoWinningResult(Map<LottoRank, Integer> lottoRankResult) {
        this.lottoWinningResult = lottoRankResult;
    }

    public static LottoWinningResult from(Map<LottoRank, Integer> lottoRankResult) {
        return new LottoWinningResult(lottoRankResult);
    }

    public Map<LottoRank, Integer> getLottoWinningResult() {
        return lottoWinningResult;
    }
}
