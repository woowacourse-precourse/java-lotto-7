package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {
    public static Map<Rank, Integer> calculateResults(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = LottoChecker.check(lotto, winningNumbers);
            if (rank != Rank.NONE) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        }
        return rankCounts;
    }

    public static int calculateTotalPrize(Map<Rank, Integer> rankCounts) {
        int total = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            total += entry.getKey().getPrize() * entry.getValue();
        }
        return total;
    }
}