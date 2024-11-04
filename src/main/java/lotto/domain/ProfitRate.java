package lotto.domain;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(Money money, PrizeResult prizeResult) {
        this.profitRate = calculateProfitRate(money, prizeResult);
    }

    private double calculateProfitRate(Money money, PrizeResult prizeResult) {
        int prizeProfit = prizeResult.getSumOfProfit();
        int tryMoney = money.money();

        double rawProfitRate = prizeProfit * 1.0 / tryMoney;
        return Math.round(rawProfitRate * 10) / 10.0;
    }
}
