package lotto.analytics;

class Analyzer {

    private static final double PERCENTAGE_VALUE = 100;

    public double calculateRate(double payment, double totalPrizeAmount) {

        return (totalPrizeAmount / payment) * PERCENTAGE_VALUE;
    }
}
