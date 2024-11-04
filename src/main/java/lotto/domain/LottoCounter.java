package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class LottoCounter {
    private final Map<LottoRank, Integer> rankCountMap = new EnumMap<>(LottoRank.class);

    public void addResult(LottoRank rank) {
        rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
    }

    public int getMatchCount(LottoRank rank) {
        return rankCountMap.getOrDefault(rank, 0);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCountMap;
    }
}