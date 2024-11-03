package lotto.constant;

import java.util.EnumMap;
import java.util.Map;

public class LottoResultsTracker {
    Map<LottoRank, Integer> rankCounts;

    public LottoResultsTracker() {
        rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void incrementRankCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getRankCount(LottoRank rank) {
        return this.rankCounts.get(rank);
    }
}
