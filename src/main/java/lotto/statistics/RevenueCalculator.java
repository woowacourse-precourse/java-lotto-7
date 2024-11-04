package lotto.statistics;

import java.util.Arrays;
import lotto.core.PurchaseAmount;

public class RevenueCalculator {

    private static final int PERCENT = 100;

    public static double calculateRevenue(PurchaseAmount purchaseAmount) {
        return expressDecimal(revenueRate(purchaseAmount));
    }

    private static double expressDecimal(double revenue) {
        return Math.round(revenue * 100) / 100.0;
    }

    private static double revenueRate(PurchaseAmount purchaseAmount) {
        return purchaseAmount.revenueRatio(totalRevenue()) * PERCENT;
    }

    private static int totalRevenue() {
        return Arrays.stream(WinningRank.values())
                .mapToInt(WinningRank::calculateRevenue)
                .sum();
    }
}
