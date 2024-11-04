package lotto.model;

public class LottoProfitRateCalculator {
    public static double calculateProfitRate(Cost cost, WinningResult winningResult) {
        int totalPrize = winningResult.calculateTotalPrize();
        double profitRate = ((double) totalPrize / cost.getValue()) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
