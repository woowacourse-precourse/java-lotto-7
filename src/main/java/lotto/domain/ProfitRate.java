package lotto.domain;

public class ProfitRate {

    private final Double profitRate;

    public ProfitRate(Money money, LottoPrizeResult lottoPrizeResult) {
        this.profitRate = calculateProfitRate(money, lottoPrizeResult);
    }

    private Double calculateProfitRate(Money money, LottoPrizeResult lottoPrizeResult) {
        return (getTotalReward(lottoPrizeResult) * 0.1) / money.getBuyLottoCount();
    }

    private long getTotalReward(LottoPrizeResult lottoPrizeResult) {
        int totalReward = 0;

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            totalReward += lottoPrizeResult.getLottoPrizeCount(lottoPrize) * lottoPrize.getReward();
        }

        return totalReward;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
