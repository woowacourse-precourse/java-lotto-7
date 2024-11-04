package lotto;

import lotto.enums.Prize;

import java.util.List;

public class EarningsRateCalculator {
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
        return placeCount.get(0) * Prize.FIRST_PLACE.getMoney()
                + placeCount.get(1) * Prize.SECOND_PLACE.getMoney()
                + placeCount.get(2) * Prize.THIRD_PLACE.getMoney()
                + placeCount.get(3) * Prize.FOURTH_PLACE.getMoney()
                + placeCount.get(4) * Prize.FIFTH_PLACE.getMoney();
    }
}