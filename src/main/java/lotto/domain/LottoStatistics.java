package lotto.domain;

import java.util.Map;

public class LottoStatistics {
    private final Map<Winning, Integer> winningStats;
    private final double profitRate;

    public LottoStatistics(Map<Winning, Integer> winningStats, double profitRate) {
        this.winningStats = winningStats;
        this.profitRate = profitRate;
    }

    public Map<Winning, Integer> getWinningStats() {
        return winningStats;
    }

    public double getProfitRate() {
        return profitRate;
    }
}