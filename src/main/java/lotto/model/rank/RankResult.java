package lotto.model.rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RankResult {

    private final Map<Rank, Integer> rankCounts;

    public RankResult() {
        rankCounts = new HashMap<>();
    }

    public void addRank(Rank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }

}
