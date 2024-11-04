package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class RankingService {

    public void evaluateAllLottoResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos) {
            evaluateLottoResult(winningLotto, bonusNumber, lotto);
        }
    }

    public void evaluateLottoResult(Lotto winningLotto, int bonusNumber, Lotto lotto) {
        int matchCount = compareLottoNumbers(winningLotto, lotto);
        boolean isBonusMatched = lotto.getNumbers().contains(bonusNumber);

        Ranking ranking = Ranking.findByMatchCountAndBonus(matchCount, isBonusMatched);
        ranking.incrementCount();
    }

    public int compareLottoNumbers(Lotto winningLotto, Lotto lotto) {
        int count = 0;

        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }
}
