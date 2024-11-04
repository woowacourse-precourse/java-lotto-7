package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRank(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getCountForRank(LottoRank rank) {
        return rankCounts.get(rank);
    }

    public double calculateProfitRate(int totalSpent) {
        int totalPrize = calculateTotalPrize();
        return (totalPrize / (double) totalSpent) * 100;
    }

    private int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
