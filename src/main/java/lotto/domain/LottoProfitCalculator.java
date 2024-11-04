package lotto.domain;

public class LottoProfitCalculator {
    private final int purchaseAmount;
    private int totalPrize;

    public LottoProfitCalculator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.totalPrize = 0;
    }

    public void addPrize(int prize) {
        this.totalPrize += prize;
    }

    public double getProfitRate() {
        if (purchaseAmount == 0 || totalPrize == 0) {
            return 0.0;
        }
        double rate = (totalPrize * 100.0) / purchaseAmount;
        return Math.round(rate * 10.0) / 10.0;
    }
}