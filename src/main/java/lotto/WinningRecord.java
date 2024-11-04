package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningRecord {
    private final Map<Rank, Integer> winningRecord = new HashMap<>();
    private final static int DEFAULT_RANK_COUNT = 0;

    public void put(final Rank rank) {
        Integer count = get(rank);
        winningRecord.put(rank, ++count);
    }

    public int calculateTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Rank rank : winningRecord.keySet()) {
            totalWinningAmount += get(rank) * rank.getWinningAmount();
        }
        return totalWinningAmount;
    }

    public int get(final Rank rank) {
        return winningRecord.getOrDefault(rank, DEFAULT_RANK_COUNT);
    }
}
