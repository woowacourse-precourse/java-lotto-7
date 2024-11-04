package lotto.domain.simulator;

import lotto.domain.enums.Rank;

import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> rankCounts;
    private final int purchaseAmount;

    public Statistics(Map<Rank, Integer> rankCounts, int purchaseAmount) {
        this.rankCounts = rankCounts;
        this.purchaseAmount = purchaseAmount;
    }

    public double calculateReturnRate() {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return Math.round((totalPrize / (double) purchaseAmount) * 1000) / 10.0;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }
}
