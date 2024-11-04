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

    public void addResult(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getCountForRank(LottoRank rank) {
        return rankCounts.get(rank);
    }

    public double calculateReturnRate(int purchaseAmount) {
        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += (long) rank.getPrize() * rankCounts.get(rank);
        }
        return (totalPrize * 100.0) / purchaseAmount;
    }
}