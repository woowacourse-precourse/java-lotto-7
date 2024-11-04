package lotto.service;

import java.util.Map;

public class LottoResultCalculator {

    public static String determineRank(int matchCount, boolean isBonusMatch) {
        return LottoRank.determineRank(matchCount, isBonusMatch).getRankName();
    }

    public static int calculateTotalPrize(Map<LottoRank, Integer> rankCounts) {
        int totalPrize = 0;

        for (LottoRank rank : rankCounts.keySet()) {
            int prize = rank.getPrize();
            int count = rankCounts.get(rank);
            totalPrize += prize * count;
        }

        return totalPrize;
    }

    public static double calculateRevenueRate(int totalPrize, int purchaseAmount) {
        double revenue = (double) totalPrize / purchaseAmount * 100;
        return Math.round(revenue * 100.0) / 100.0;
    }
}
