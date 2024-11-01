package lotto.model;

import java.util.Map;

public class ProfitCalculator {

    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    private static final int FOURTH_PRIZE = 50_000;
    private static final int FIFTH_PRIZE = 5_000;

    public static double calculateProfitRate(Map<String, Integer> lottoResult, int purchaseAmount) {
        int totalPrize = 0;

        totalPrize += lottoResult.getOrDefault("1등", 0) * FIRST_PRIZE ;
        totalPrize += lottoResult.getOrDefault("2등", 0) * SECOND_PRIZE ;
        totalPrize += lottoResult.getOrDefault("3등", 0) * THIRD_PRIZE;
        totalPrize += lottoResult.getOrDefault("4등", 0) * FOURTH_PRIZE;
        totalPrize += lottoResult.getOrDefault("5등", 0) * FIFTH_PRIZE;

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
