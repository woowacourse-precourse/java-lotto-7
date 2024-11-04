package lotto.model;

import static lotto.properties.LottoProperties.LOTTO_REVENUE_RATE;
import static lotto.properties.LottoProperties.SCALE_FACTOR;

public class Revenue {

    private int revenueAmount;
    private int invest;
    private double revenueRate;

    private Revenue(int purchaseAmount) {
        this.revenueAmount = 0;
        this.revenueRate = 0;
        this.invest = purchaseAmount;
    }

    public void updateRevenue(Rank rank) {
        revenueAmount += rank.getWinningPrice();
    }

    public void updateRevenueRate() {
        revenueRate = ((double) revenueAmount / (double) invest) * LOTTO_REVENUE_RATE;
        revenueRate = Math.round(revenueRate * SCALE_FACTOR) / SCALE_FACTOR;
    }

    public double getRevenueRate() {
        return revenueRate;
    }

    public static Revenue init(int invest){
        return new Revenue(invest);
    }
}
