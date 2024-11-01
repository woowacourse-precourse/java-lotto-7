package lotto.domain;

public class ReturnRateCalculator {

    public double calculateReturnRate(double totalEarnings, double totalSpent) {
        if (totalSpent == 0) {
            return 0;
        }
        return calculateRate(totalEarnings, totalSpent);
    }

    private double calculateRate(double totalEarnings, double totalSpent) {
        double returnRate = (totalEarnings / totalSpent) * 100;
        return Math.round(returnRate * 100.0) / 100.0;
    }
}