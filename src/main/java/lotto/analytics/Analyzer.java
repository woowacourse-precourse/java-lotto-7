package lotto.analytics;

class Analyzer {

    private static final double PERCENTAGE_VALUE = 100;

    public double calculateRate(double payment, double totalPrizeAmount) {
        double divisionResult = (totalPrizeAmount / payment) * PERCENTAGE_VALUE;
        String roundingResult = String.format("%.1f", divisionResult);

        return Double.parseDouble(roundingResult);
    }
}
