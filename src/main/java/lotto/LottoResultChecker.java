package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {

    public Map<WinningRank, Integer> checkResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<WinningRank, Integer> results = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            WinningRank rank = WinningRank.valueOf(matchCount, bonusMatch);

            if (rank != null) {
                results.put(rank, results.getOrDefault(rank, 0) + 1);
            }
        }
        return results;
    }
}
