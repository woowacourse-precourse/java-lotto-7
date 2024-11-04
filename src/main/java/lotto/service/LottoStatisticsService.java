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
        printWinningCount(winningStats, Winning.FIFTH, "3개 일치 (5,000원)");
        printWinningCount(winningStats, Winning.FOURTH, "4개 일치 (50,000원)");
        printWinningCount(winningStats, Winning.THIRD, "5개 일치 (1,500,000원)");
        printWinningCount(winningStats, Winning.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        printWinningCount(winningStats, Winning.FIRST, "6개 일치 (2,000,000,000원)");
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
            winningStats.put(winning, winningStats.get(winning) + 1);
        }

        return winningStats;
    }

    private static void printWinningCount(Map<Winning, Integer> stats, Winning winning, String description) {
        System.out.printf("%s - %d개%n", description, stats.get(winning));
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