package lotto.domain;

import java.util.EnumMap;

public class LottoRankSummary {
    private final EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

    public LottoRankSummary() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void incrementCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }
}
