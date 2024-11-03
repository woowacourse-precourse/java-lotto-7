package lotto.domain;

public class ProfitRate {
    private final double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate of(double purchaseAmount, double totalPrize) {
        return new ProfitRate(totalPrize / purchaseAmount * 100.0);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
