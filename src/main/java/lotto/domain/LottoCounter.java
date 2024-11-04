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

    // rankCountMap에 접근하기 위한 메서드 추가
    public Map<LottoRank, Integer> getRankCounts() {
        return rankCountMap;
    }
}