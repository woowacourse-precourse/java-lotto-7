package lotto.util;

public abstract class EarningCalculator {

    private EarningCalculator() {
    }

    public static String calculateEarningsRate(int winningAmount, int purchaseAmount) {
        double earningsRate = (double) winningAmount * 100 / purchaseAmount;
        double roundedEarningsRate = Math.round(earningsRate * 10) / 10.0;
        return String.format("%,.1f", roundedEarningsRate);
    }
}
