package lotto.domain.winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> rankCounts;

    public WinningResult(List<Rank> ranks) {
        this.rankCounts = calculateRankCounts(ranks);
    }

    private Map<Rank, Integer> calculateRankCounts(List<Rank> ranks) {
        Map<Rank, Integer> counts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            counts.put(rank, 0);
        }
        for (Rank rank : ranks) {
            counts.put(rank, counts.get(rank) + 1);
        }
        return counts;
    }

    public int getRankCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public int getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}