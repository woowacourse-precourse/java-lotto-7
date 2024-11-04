package lotto.domain;

public class ReturnRate {

    private final double profitRate;

    private ReturnRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ReturnRate of(int totalPayment , long totalPrize) {
        double profitRate = (double) totalPrize / totalPayment * 100;
        return new ReturnRate(profitRate);
    }

    public double getReturnRate() {
        return profitRate;
    }
}
