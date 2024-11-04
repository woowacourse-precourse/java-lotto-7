package lotto.model;

import java.util.List;

import static lotto.properties.LottoProperties.LOTTO_REVENUE_RATE;
import static lotto.properties.LottoProperties.SCALE_FACTOR;

public class Revenue {

    private int revenueAmount;
    private double revenueRate;

    public Revenue(int revenueAmount) {
        this.revenueAmount = revenueAmount;
        this.revenueRate = 0;
    }

    public void updateRevenueRate(int purchaseAmount) {
        revenueRate = ((double) revenueAmount / (double) purchaseAmount) * LOTTO_REVENUE_RATE;
        revenueRate = Math.round(revenueRate * SCALE_FACTOR) / SCALE_FACTOR;
    }

    public double getRevenueRate() {
        return revenueRate;
    }

    public static Revenue from(List<Rank> ranks) {
        int revenueAmount = ranks.stream()
                .mapToInt(Rank::getWinningPrice)
                .sum();
        return new Revenue(revenueAmount);
    }
}
