package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningRecord {
    private final Map<Rank, Integer> winningRecord = new HashMap<>();
    private final static int DEFAULT_RANK_COUNT = 0;

    public void put(final Rank rank) {
        int count = getRankCount(rank);
        winningRecord.put(rank, ++count);
    }

    public int calculateTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Rank rank : winningRecord.keySet()) {
            totalWinningAmount += getRankCount(rank) * rank.getWinningAmount();
        }
        return totalWinningAmount;
    }

    public int getRankCount(final Rank rank) {
        return winningRecord.getOrDefault(rank, DEFAULT_RANK_COUNT);
    }
}
