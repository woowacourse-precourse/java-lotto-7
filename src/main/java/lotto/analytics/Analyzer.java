package lotto.analytics;

public class Analyzer {

    private static final double ROUNDING_CORRECTION_VALUE = 10.0;

    public void tellGrowthRate(double payment, double totalPrizeAmount) {
        new RateSheet().printGrowthRate(calculateRate(payment, totalPrizeAmount));
    }

    public double calculateRate(double payment, double totalPrizeAmount) {
        double correctingResult = Math.round(totalPrizeAmount * ROUNDING_CORRECTION_VALUE);
        double divisionResult = (correctingResult / payment);
        double reCorrectingResult = divisionResult / ROUNDING_CORRECTION_VALUE;

        return reCorrectingResult * 100;
    }
}
