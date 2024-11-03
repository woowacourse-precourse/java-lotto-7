package lotto.service;

import lotto.domain.LottoRank;

public class LottoRevenueCalculator {
    private static final int PERCENT_CONVERSION = 100;
    private static final int ROUNDING_SCALE = 10;

    public long calculateTotalRevenue(int[] rankCounts) {
        long totalRevenue = 0;
        for (int i = 0; i < LottoRank.values().length; i++) {
            totalRevenue += LottoRank.values()[i].getPrize() * rankCounts[i];
        }
        return totalRevenue;
    }

    public float calculateRateOfRevenue(int[] rankCounts, int money) {
        long totalRevenue = calculateTotalRevenue(rankCounts);
        float rateOfRevenue = (float) totalRevenue / money * PERCENT_CONVERSION;
        rateOfRevenue = (float) Math.round(rateOfRevenue * ROUNDING_SCALE) / ROUNDING_SCALE;
        return rateOfRevenue;
    }
}
