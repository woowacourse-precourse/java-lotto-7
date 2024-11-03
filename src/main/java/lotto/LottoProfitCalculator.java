package lotto;

import java.util.Map;

public class LottoProfitCalculator {
	private static final double PERCENTAGE = 100.0;
    private static final int LOTTO_PRICE = 1000;

    public static double calculate(int purchaseCount, Map<WinningRank, Integer> rankCounts) {
        long totalPrize = calculateTotalPrize(rankCounts);
        int totalCost = purchaseCount * LOTTO_PRICE;
        
        return Math.round((totalPrize * PERCENTAGE / totalCost) * 10.0) / 10.0;
    }

    private static long calculateTotalPrize(Map<WinningRank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}
