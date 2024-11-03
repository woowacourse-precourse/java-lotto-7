package lotto.model;

import java.util.Map;

public class ProfitCalculator {
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
