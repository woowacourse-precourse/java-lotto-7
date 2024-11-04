package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.enums.Rank;

public class WinningResult {
    private final Map<Rank, Integer> rankCountMap;

    public WinningResult() {
        this.rankCountMap = initializeRankCountMap();
    }

    public void updateResult(Rank rank) {
        rankCountMap.put(rank, rankCountMap.get(rank) + 1);
    }

    private Map<Rank, Integer> initializeRankCountMap() {
        Map<Rank, Integer> rankCountMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
        return rankCountMap;
    }

    public int getRankCount(Rank rank) {
        return rankCountMap.get(rank);
    }
}
