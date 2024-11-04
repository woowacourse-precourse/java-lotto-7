package lotto.service;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Rank;

public class WinningStatistics {
    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public WinningStatistics() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return rankCounts.get(rank);
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += (long) rank.getPrize() * rankCounts.get(rank);
        }
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
