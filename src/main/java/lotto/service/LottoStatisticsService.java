package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.Winning;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsService {

    public static void printStatistics(List<LottoResult> results, int totalPurchaseAmount) {
        Map<Winning, Integer> winningStats = calculateWinningStatistics(results);
        int totalWinningAmount = calculateTotalWinningAmount(results);
        double profitRate = calculateProfitRate(totalWinningAmount, totalPurchaseAmount);

        System.out.println("---");
        printWinningResults(winningStats);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static Map<Winning, Integer> calculateWinningStatistics(List<LottoResult> results) {
        Map<Winning, Integer> winningStats = new EnumMap<>(Winning.class);

        // Initialize counts to 0
        for (Winning winning : Winning.values()) {
            winningStats.put(winning, 0);
        }

        // Count occurrences
        for (LottoResult result : results) {
            Winning winning = result.getWinning();
            winningStats.merge(winning, 1, Integer::sum);
        }

        return winningStats;
    }

    private static void printWinningResults(Map<Winning, Integer> stats) {
        LottoResult[] results = {
                new LottoResult(Winning.FIFTH),
                new LottoResult(Winning.FOURTH),
                new LottoResult(Winning.THIRD),
                new LottoResult(Winning.SECOND),
                new LottoResult(Winning.FIRST)
        };

        for (LottoResult result : results) {
            Winning winning = result.getWinning();
            String message = result.toString();
            if (winning != Winning.NONE) {
                System.out.printf("%s - %d개%n", message, stats.get(winning));
            }
        }
    }

    private static int calculateTotalWinningAmount(List<LottoResult> results) {
        return results.stream()
                .mapToInt(LottoResult::getReward)
                .sum();
    }

    private static double calculateProfitRate(int totalWinningAmount, int totalPurchaseAmount) {
        return (totalWinningAmount * 100.0) / totalPurchaseAmount;
    }
}