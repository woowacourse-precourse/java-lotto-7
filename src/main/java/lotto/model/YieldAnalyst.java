package lotto.model;

public class YieldAnalyst {

    private static final double PERCENTAGE = 100.0;
    private static final double ROUNDING_FACTOR = 10.0;

    public double calculateYield(int purchaseCost, int totalEarnings) {
        double yield = ((double) totalEarnings / purchaseCost) * PERCENTAGE;
        return Math.round(yield * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }
}
