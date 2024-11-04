package lotto.model;

import java.util.Map;

public class CalProfitRate {

    public static double calculateProfitRate(Map<Rank, Integer> results, int lottoCount) {
        int totalSpent = lottoCount * Lotto.LOTTO_PRICE;
        double totalProfit = 0;

        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalProfit += rank.getPrize() * count;
        }

        return (totalProfit / totalSpent) * 100;
    }
}
