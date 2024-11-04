package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultSystem {
    Map<Integer, Integer> results = new HashMap<>();
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultSystem(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void displayResults(List<Lotto> purchasedLottos, Integer money) {
        Map<Integer, Integer> matchResults = calculateMatchResults(purchasedLottos);
        int bonusMatchCount = calculateBonusMatches(purchasedLottos);
        LottoSweepstakesTvShow lottoTV = new LottoSweepstakesTvShow(matchResults, bonusMatchCount);
        lottoTV.printResults(money);
    }

    public Map<Integer, Integer> calculateMatchResults(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            updateMatchResults(lotto);
        }
        return results;
    }

    private void updateMatchResults(Lotto lotto) {
        int matchCount = lotto.countMatches(winningNumbers);
        if (isBonusMatch(matchCount, lotto)) {
            return;
        }
        results.put(matchCount, results.getOrDefault(matchCount, 0) + 1);
    }

    public boolean isBonusMatch(int matchCount, Lotto lotto) {
        return ((matchCount == 5) && (lotto.containsBonusNumber(bonusNumber)));
    }

    public int calculateBonusMatches(List<Lotto> purchasedLottos) {
        int bonusMatchCount = 0;
        for (Lotto lotto : purchasedLottos) {
            if (isBonusMatch(lotto.countMatches(winningNumbers), lotto)) {
                bonusMatchCount++;
            }
        }
        return bonusMatchCount;
    }
}
