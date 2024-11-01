package lotto;

import java.util.Arrays;

public class RevenueCalculator {

    private static final int PERCENT = 100;

    public static double calculateRevenue(int purchaseAmount) {
        return expressDecimal(revenueRate(purchaseAmount));
    }

    private static double expressDecimal(double revenue) {
        return Math.round(revenue * 100) / 100.0;
    }

    private static double revenueRate(int purchaseAmount) {
        return (double) totalRevenue() / purchaseAmount * PERCENT;
    }

    private static int totalRevenue() {
        return Arrays.stream(WinningRank.values())
                .mapToInt(WinningRank::calculateRevenue)
                .sum();
    }
}
