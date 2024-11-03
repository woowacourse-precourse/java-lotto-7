package lotto;

public class LottoRevenue {
    public static double calculateRevenueRate(int totalLottoPurchaseCost, int totalPrize) {
        if (totalLottoPurchaseCost <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 비용은 0보다 커야 합니다.");
        }
        return Math.round((double) totalPrize / totalLottoPurchaseCost * 10000) / 100.0;
    }
}
