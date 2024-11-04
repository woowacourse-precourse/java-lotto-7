package lotto.domain.result;

public class WinningResult {
    private final WinningStatistics statistics;
    private final double profitRate;

    private WinningResult(WinningStatistics statistics, double profitRate) {
        this.statistics = statistics;
        this.profitRate = profitRate;
    }

    public static WinningResult of(WinningStatistics statistics, double profitRate) {
        return new WinningResult(statistics, profitRate);
    }

    public WinningStatistics getStatistics() {
        return statistics;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public int getWinningCount(LottoRank rank) {
        return statistics.getWinningCount(rank);
    }
}