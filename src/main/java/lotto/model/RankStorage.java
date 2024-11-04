package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class RankStorage {
    private final Map<Integer, Integer> rankCounts = new HashMap<>();

    public RankStorage() {
        for (int rank = 1; rank <= 5; rank++) {
            rankCounts.put(rank, 0);
        }
    }

    public void increaseRankCount(int rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getRankCount(int rank) {
        return rankCounts.get(rank);
    }
}

