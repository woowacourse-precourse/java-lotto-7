package lotto.model;

import java.util.Map;

public class ProfitCalculator {

    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    private static final int FOURTH_PRIZE = 50_000;
    private static final int FIFTH_PRIZE = 5_000;

    public static double calculateProfitRate(Map<Rank, Integer> lottoResult, int purchaseAmount) {
        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();

            totalPrize += rank.getPrize() * count;

        }

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
