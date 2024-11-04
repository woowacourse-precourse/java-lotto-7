package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public LottoResult() {
        initializeRankCounts();
    }

    private void initializeRankCounts() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / purchaseAmount * 100;
    }

    private long calculateTotalPrize() {
        long total = 0;
        for (Rank rank : Rank.values()) {
            total += (long) rank.getPrize() * rankCounts.get(rank);
        }
        return total;
    }

}

