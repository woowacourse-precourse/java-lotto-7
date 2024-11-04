package lotto.domain;

public class ProfitRate {

    private static final double PERCENTAGE_MULTIPLIER = 100.0;
    private static final double ROUNDING_FACTOR = 10.0;

    private final double profitRate;

    public ProfitRate(Money money, PrizeResult prizeResult) {
        this.profitRate = calculateProfitRate(money, prizeResult);
    }

    public double getProfitRate() {
        return profitRate;
    }

    private double calculateProfitRate(Money money, PrizeResult prizeResult) {
        int prizeProfit = prizeResult.getSumOfProfit();
        int tryMoney = money.money();

        double rawProfitRate = prizeProfit * PERCENTAGE_MULTIPLIER / tryMoney;
        return Math.round(rawProfitRate * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }
}
