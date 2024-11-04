package lotto.domain;

public class ProfitCalculator {
    public double calculateProfitRate(int totalPrize, int purchaseAmount) {
        double returnRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(returnRate * 10) / 10.0;
    }
}