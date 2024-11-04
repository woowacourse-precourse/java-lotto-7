package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static Map<Rank, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> results = initializeResults();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.getRank(winningNumbers, bonusNumber);
            if (rank != null) {
                results.put(rank, results.get(rank) + 1);
            }
        }
        return results;
    }

    private static Map<Rank, Integer> initializeResults() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        return results;
    }
}