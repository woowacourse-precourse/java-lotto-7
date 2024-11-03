package lotto.view.response;

import lotto.model.Score;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoScoreResponses {

    private final Map<LottoScoreResponse, Integer> lottoScoreResponses;

    private LottoScoreResponses(Map<LottoScoreResponse, Integer> lottoScoreResponses) {
        this.lottoScoreResponses = lottoScoreResponses;
    }

    public static LottoScoreResponses from(Map<Score, Integer> scores) {
        Map<LottoScoreResponse, Integer> lottoScoreResponses = new LinkedHashMap<>();
        scores.forEach((score, count) -> lottoScoreResponses.put(LottoScoreResponse.from(score), count));

        return new LottoScoreResponses(lottoScoreResponses);
    }

    public Map<LottoScoreResponse, Integer> getLottoScoreResponses() {
        return lottoScoreResponses;
    }
}
