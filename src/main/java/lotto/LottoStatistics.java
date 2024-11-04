package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public LottoStatistics() {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return rankCount.get(rank);
    }

    public long calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return Math.round((double) totalPrize / purchaseAmount * 100 * 10) / 10.0;
    }

}
