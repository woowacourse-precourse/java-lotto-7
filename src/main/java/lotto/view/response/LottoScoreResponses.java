package lotto.view.response;

import lotto.model.Score;

import java.util.HashMap;
import java.util.Map;

public class LottoScoreResponses {

    private final Map<LottoScoreResponse, Integer> lottoScoreResponses;

    private LottoScoreResponses(Map<Score, Integer> scores) {
        this.lottoScoreResponses = new HashMap<>();
        scores.forEach((score, count) -> lottoScoreResponses.put(LottoScoreResponse.from(score), count));
    }

    public static LottoScoreResponses from(Map<Score, Integer> scores) {
        return new LottoScoreResponses(scores);
    }

    public Map<LottoScoreResponse, Integer> getLottoScoreResponses() {
        return lottoScoreResponses;
    }
}
