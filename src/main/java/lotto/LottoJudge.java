package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.score.Prize;

public class LottoJudge {
    public Map<Prize, Integer> calculateLottoScore(List<Lotto> lottos, LottoWinningSet lottoWinningSet) {
        Map<Prize, Integer> score = initializeLottoScore();
        evaluateLottoScore(lottos, lottoWinningSet, score);
        return score;
    }

    private Map<Prize, Integer> initializeLottoScore() {
        return Arrays.stream(Prize.values())
                .collect(Collectors.toMap(prize -> prize, prize -> 0));
    }

    private void evaluateLottoScore(List<Lotto> lottos, LottoWinningSet lottoWinningSet, Map<Prize, Integer> score) {
        for (Lotto lotto : lottos) {
            Prize prize = determinePrizeForLotto(lottoWinningSet, lotto);
            increasePrizeCount(score, prize);
        }
    }

    private Prize determinePrizeForLotto(LottoWinningSet lottoWinningSet, Lotto lotto) {
        int matchingNumberCount = lottoWinningSet.calculateMatchingNumberCount(lotto);
        boolean bonusNumberMatch = lottoWinningSet.hasMatchingBonusNumber(lotto);
        return Prize.calculateScore(matchingNumberCount, bonusNumberMatch);
    }

    private void increasePrizeCount(Map<Prize, Integer> score, Prize prize) {
        int newCount = score.get(prize) + 1;
        score.put(prize, newCount);
    }
}
