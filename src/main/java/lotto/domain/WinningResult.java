package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class WinningResult {
    private final Map<Rank, Integer> results;

    public WinningResult() {
        results = new EnumMap<>(Rank.class);
        initializeResults();
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }

    public double calculateTotalReturn(int totalAmount) {
        int totalPrize = calculateTotalPrize();
        return calculateReturnPercentage(totalPrize, totalAmount);
    }

    private void initializeResults() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    private int calculateTotalPrize() {
        return results.entrySet().stream()
                .mapToInt(this::calculatePrizeForRank)
                .sum();
    }

    private double calculateReturnPercentage(int totalPrize, int totalAmount) {
        return (totalPrize / (double) totalAmount) * 100;
    }

    private int calculatePrizeForRank(Entry<Rank, Integer> entry) {
        return entry.getKey().getPrize() * entry.getValue();
    }
}
