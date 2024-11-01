package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private int totalPrizeAmount;
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void incrementRankCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
        totalPrizeAmount += rank.getPrize();
    }

    public int getTotalPrizeAmount() {
        return totalPrizeAmount;
    }

    public int getRankCount(LottoRank rank) {
        return rankCounts.get(rank);
    }

}
