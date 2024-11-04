package lotto.service;

import lotto.model.Rank;

import java.util.Map;

public class LottoStatisticsService {

    public int calculateTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    public double calculateProfitRate(int totalPrize, int purchaseAmount) {
        double profit = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profit * 10) / 10.0;
    }
}
