package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;

    public LottoResult(Map<Rank, Integer> rankCounts) {
        validateRankCounts(rankCounts);
        this.rankCounts = new EnumMap<>(rankCounts);
    }

    private void validateRankCounts(Map<Rank, Integer> rankCounts) {
        if (rankCounts == null || rankCounts.isEmpty()) {
            throw new IllegalStateException("당첨 결과가 계산되지 않았습니다.");
        }
    }

    public int getCountByRank(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> getRankCounts() {
        return new EnumMap<>(rankCounts);
    }
}
