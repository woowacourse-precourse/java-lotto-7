package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private Map<Rank, Integer> result;

    public WinningResult() {
        this.result = new EnumMap<>(Rank.class);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public double calculateProfitRate(int purchaseAmount) {
        double prizeAmount = 0;

        for (Rank rank : Rank.values()) {
            prizeAmount += result.getOrDefault(rank, 0) * rank.getPrize();
        }

        return (prizeAmount / purchaseAmount) * 100;
    }
}