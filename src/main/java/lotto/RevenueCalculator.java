package lotto;

import java.util.Arrays;

public class RevenueCalculator {

    public static double revenueRate(int purchaseAmount) {
        return Math.round((double) totalRevenue() / purchaseAmount * 100 * 100) / 100.0;
    }

    private static int totalRevenue() {
        return Arrays.stream(WinningRank.values())
                .mapToInt(WinningRank::calculateRevenue)
                .sum();
    }
}
