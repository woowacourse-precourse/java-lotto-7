package lotto.domain.winning;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private final Map<Rank, Integer> result = new HashMap<>();

    public WinningStatistics() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void addWinCountByRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getCountByRank(Rank rank) {
        return result.get(rank);
    }

}
