package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.category.Rank;

public class RankCounter {
    private final Map<Rank, Integer> rankCounter;

    private RankCounter(Map<Rank, Integer> rankCounter) {
        this.rankCounter = rankCounter;
    }

    public static RankCounter create() {
        return new RankCounter(initializeCounter());
    }

    private static Map<Rank, Integer> initializeCounter() {
        Map<Rank, Integer> counter = new HashMap<>();
        for (Rank rank : Rank.values()) {
            counter.put(rank, 0);
        }
        return counter;
    }

    public Integer getRankCount(Rank rank) {
        return rankCounter.get(rank);
    }

    public void increaseRankCount(Rank rank) {
        rankCounter.put(rank, rankCounter.get(rank) + 1);
    }
}
