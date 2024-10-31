package lotto.model;

import java.util.Map;

public class WinningResult {

    public static final int PERCENTAGE = 100;

    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public Integer getWinningCount(Rank rank) {
        return result.get(rank);
    }

    public double getProfitRate() {
        return (totalPrize() / (double) (totalCount() * 1000)) * PERCENTAGE;
    }

    private long totalPrize() {
        return result.keySet().stream()
            .mapToLong(rank -> rank.totalPrize(this))
            .sum();
    }

    private int totalCount() {
        return result.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

}
