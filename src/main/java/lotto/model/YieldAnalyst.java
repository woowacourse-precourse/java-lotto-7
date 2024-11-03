package lotto.model;

public class YieldAnalyst {

    public double calculateYield(int purchaseCost, int totalEarnings) {
        double yield = ((double) totalEarnings / purchaseCost) * 100;
        return Math.round(yield * 10.0) / 10.0;
    }
}
