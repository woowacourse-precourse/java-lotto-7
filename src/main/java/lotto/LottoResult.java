// LottoResult.java
package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        calculateResults(lottos, winningLotto, bonusNumber);
    }

    private void calculateResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(winningLotto);
            boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public int getTotalPrize() {
        int total = 0;
        for (Rank rank : results.keySet()) {
            total += rank.getPrize() * results.get(rank);
        }
        return total;
    }
}