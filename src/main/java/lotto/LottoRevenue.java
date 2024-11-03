package lotto;

public class LottoRevenue {
    public static double calculateRevenueRate(int totalLottoPurchaseCost, int totalPrize) {
        return Math.round((double) totalPrize / totalLottoPurchaseCost * 10000) / 100.0;
    }
}
