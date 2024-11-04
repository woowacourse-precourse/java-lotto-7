package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.domain.Winning;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsService {

    public LottoStatistics calculateStatistics(List<LottoResult> results, int buyingPrice) {
        Map<Winning, Integer> winningStats = calculateWinningStatistics(results);
        int totalWinningAmount = calculateTotalWinningAmount(results);
        double profitRate = calculateProfitRate(totalWinningAmount, buyingPrice);

        return new LottoStatistics(winningStats, profitRate);
    }

    private Map<Winning, Integer> calculateWinningStatistics(List<LottoResult> results) {
        Map<Winning, Integer> winningStats = new EnumMap<>(Winning.class);

        for (Winning winning : Winning.values()) {
            winningStats.put(winning, 0);
        }

        for (LottoResult result : results) {
            Winning winning = result.getWinning();
            winningStats.merge(winning, 1, Integer::sum);
        }

        return winningStats;
    }

    private int calculateTotalWinningAmount(List<LottoResult> results) {
        return results.stream()
                .mapToInt(LottoResult::getPrize)
                .sum();
    }

    private double calculateProfitRate(int totalWinningAmount, int totalPurchaseAmount) {
        return (totalWinningAmount * 100.0) / totalPurchaseAmount;
    }
}
