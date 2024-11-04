package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public static Map<Rank, Integer> calculateResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers,
                                                      int bonusNumber) {
        Map<Rank, Integer> results = new HashMap<>();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.matchCount(winningNumbers);
            boolean isBonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.determineRank(matchCount, isBonusMatch);

            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }
}
