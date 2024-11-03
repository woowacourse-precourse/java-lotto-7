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
            Score score = getScoreLotto(lotto, winningNumbers);
            resultCount.put(score, resultCount.getOrDefault(score, 0) + 1);
        }
        return resultCount;
    }

    private Score getScoreLotto(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Score.getScore(matchCount, bonusMatch);
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
