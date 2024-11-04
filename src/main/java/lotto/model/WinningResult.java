package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import lotto.rank.Ranking;

public class WinningResult {
    private final Map<Ranking, Integer> rankCounts;
    private long totalPrize;

    public WinningResult() {
        rankCounts = new EnumMap<>(Ranking.class);
        for (Ranking rank : Ranking.values()) {
            rankCounts.put(rank, 0);
        }
        totalPrize = 0;
    }

    public void addRankCount(Ranking rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
        totalPrize += rank.getPrize();
    }

    public Map<Ranking, Integer> getRankCounts() {
        return rankCounts;
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}
