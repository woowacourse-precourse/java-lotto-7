package lotto.domain;

import static lotto.global.LottoScore.NO_PRIZE;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.global.LottoScore;

public class LottoResult {

    private Map<LottoScore, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        for (LottoScore score : LottoScore.values()) {
            lottoResult.put(score, 0);
        }
    }

    public Map<LottoScore, Integer> integrateLottoScore(List<LottoScore> lottoScores) {
        for (LottoScore lottoScore : lottoScores) {
            if (lottoScore == NO_PRIZE) {
                continue;
            }
            lottoResult.put(lottoScore, lottoResult.get(lottoScore) + 1);
        }

        return lottoResult;
    }

    public void deleteNoPrize() {
        lottoResult.remove(NO_PRIZE);
    }
}