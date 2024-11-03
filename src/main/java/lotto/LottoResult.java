package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult() {
        rankCounts = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRankCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}
