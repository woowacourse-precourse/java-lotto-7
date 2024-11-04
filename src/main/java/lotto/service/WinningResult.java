package lotto.service;

import java.util.List;
import lotto.domain.MatchResult;
import lotto.domain.WinningStatistics;

public class WinningResult {
    private final WinningStatistics statistics;

    public WinningResult() {
        this.statistics = new WinningStatistics();
    }

    public void processMatchResults(List<MatchResult> results) {
        results.forEach(statistics::putRankCount);
    }

    public WinningStatistics getStatistics() {
        return statistics;
    }

    public double getProfitRate(int purchaseAmount) {
        return statistics.calculateProfitRate(purchaseAmount);
    }
}
