package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class RankCount {
    private Map<Rank, Integer> rankCount;

    public RankCount() {
        this.rankCount = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> this.rankCount.put(rank, 0));
    }

    public void increaseCount(Rank rank) {
        this.rankCount.put(rank, this.rankCount.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankCount() {
        return new HashMap<>(rankCount);
    }
}
