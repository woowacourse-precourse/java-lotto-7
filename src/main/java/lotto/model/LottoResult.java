package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


    public Map<Score, Integer> calculateResults(LottoList lottoList) {
        Map<Score, Integer> resultCount = new HashMap<>();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        for (Lotto lotto : lottoList.getLottoList()) {
            int matchCount = 0;
            boolean bonusMatch = false;

            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
                if (number == bonusNumber) {
                    bonusMatch = true;
                }
            }
            Score score = Score.getScore(matchCount, bonusMatch);
            resultCount.put(score, resultCount.getOrDefault(score, 0) + 1);
        }
        return resultCount;
    }
}
