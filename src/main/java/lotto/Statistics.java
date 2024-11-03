package lotto;

public class Statistics {
    public static double calculateRateOfReturn(int purchaseAmount, int profitAmount) {
        return Math.round(profitAmount / (double) purchaseAmount * 100 * 10) / 10.0;
    }
}
