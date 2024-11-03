package lotto.service;

import lotto.domain.LottoRank;

public class LottoRevenueCalculator {
    public long calculateTotalRevenue(int[] rankCounts) {
        long totalRevenue = 0;
        for (int i = 0; i < LottoRank.values().length; i++) {
            totalRevenue += LottoRank.values()[i].getPrize() * rankCounts[i];
        }
        return totalRevenue;
    }

    public float calculateRateOfRevenue(int[] rankCounts, int money) {
        long totalRevenue = calculateTotalRevenue(rankCounts);
        float rateOfRevenue = (float) totalRevenue / money * 100;
        rateOfRevenue = (float) Math.round(rateOfRevenue * 10) / 10;
        return rateOfRevenue;
    }
}
