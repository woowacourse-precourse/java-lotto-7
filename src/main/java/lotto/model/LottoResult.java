package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.Rank;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;
    private long totalEarnings;

    public LottoResult() {
        rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        totalEarnings = 0;
    }

    public void addResult(Rank rank) {
        if (rank != Rank.NONE) {
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
            totalEarnings += rank.price();
        }
    }

    public Map<Rank, Integer> getRankCounts() {
        Map<Rank, Integer> sortedRank = new LinkedHashMap<>();
        rankCounts.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(Rank.NONE))
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                .forEach(entry -> sortedRank.put(entry.getKey(), entry.getValue()));
        return sortedRank;
    }

    public long calculateTotalEarnings() {
        return totalEarnings;
    }

    public Double calculateEarningsRate(long purchaseAmount) {
        long totalWinningPrice = calculateTotalEarnings();
        return (double) totalWinningPrice / purchaseAmount * 100;
    }
}
