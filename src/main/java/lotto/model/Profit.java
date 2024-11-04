package lotto.model;

import java.util.Map;

public class Profit {
    private final long profit;
    private final long purchaseAmount;

    public Profit(Map<Rank, Integer> lottoResult, long purchaseAmount) {
        profit = calculateProfit(lottoResult);
        this.purchaseAmount = purchaseAmount;
    }

    public double getProfitRate() {
        return profit * 100 / (double) purchaseAmount;
    }

    private long calculateProfit(Map<Rank, Integer> lottoResult) {
        long profit = 0;

        for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {

            Rank rank = entry.getKey();
            int rankCount = entry.getValue();

            profit += ((long) rank.reward * rankCount);
        }
        return profit;
    }
}
