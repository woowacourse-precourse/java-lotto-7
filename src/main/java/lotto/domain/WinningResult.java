package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult() {
        this.result = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .forEach(rank -> result.put(rank, 0));
    }

    public void add(Rank rank) {
        if (rank == Rank.MISS) {
            return;
        }
        result.put(rank, result.get(rank) + 1);
    }

    public double getProfit(int purchaseAmount) {
        double sum = result.keySet().stream()
                .mapToDouble(rank -> rank.getPrize() * result.get(rank))
                .sum();
        double profit = sum / (double) purchaseAmount * 100;
        return Math.round(profit * 100) / 100.0;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
