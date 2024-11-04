package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> rankCount = new HashMap<>();
    private final int totalSpent;

    public Result(int totalSpent) {
        this.totalSpent = totalSpent;
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void updateResult(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public double calculateYield() {
        int totalReward = rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        return (double) totalReward / totalSpent * 100;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }
}