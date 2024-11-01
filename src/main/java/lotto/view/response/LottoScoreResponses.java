package lotto.view.response;

import java.util.Map;

public class LottoScoreResponses {

    private final Map<LottoScoreResponse, Integer> lottoScoreResponses;

    private LottoScoreResponses(Map<LottoScoreResponse, Integer> lottoScoreResponses) {
        this.lottoScoreResponses = lottoScoreResponses;
    }

    public static LottoScoreResponses from(Map<LottoScoreResponse, Integer> lottoScoreResponses) {
        return new LottoScoreResponses(lottoScoreResponses);
    }

    public Map<LottoScoreResponse, Integer> getLottoScoreResponses() {
        return lottoScoreResponses;
    }
}
