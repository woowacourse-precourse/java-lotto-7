package lotto;

import java.util.List;

public class EarningsRateCalculator {
    private static final long FIRST_PLACE_PRIZE = 2000000000;
    private static final long SECOND_PLACE_PRIZE = 30000000;
    private static final long THIRD_PLACE_PRIZE = 1500000;
    private static final long FOURTH_PLACE_PRIZE = 50000;
    private static final long FIFTH_PLACE_PRIZE = 5000;
    private final List<Integer> placeCount;
    private final long purchaseAmount;

    public EarningsRateCalculator(List<Integer> placeCount, long purchaseAmount) {
        this.placeCount = placeCount;
        this.purchaseAmount = purchaseAmount;
    }

    public double getEarningsRate() {
        return Math.round((double) calculateNetProfit() / purchaseAmount * 100 * 10) / 10.0;
    }

    private long calculateNetProfit() {
        return placeCount.get(0) * FIRST_PLACE_PRIZE
                + placeCount.get(1) * SECOND_PLACE_PRIZE
                + placeCount.get(2) * THIRD_PLACE_PRIZE
                + placeCount.get(3) * FOURTH_PLACE_PRIZE
                + placeCount.get(4) * FIFTH_PLACE_PRIZE;
    }
}