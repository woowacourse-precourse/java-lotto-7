package lotto;

import lotto.enums.Rank;

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
        return placeCount.get(Rank.FIRST_PLACE.getIndex()) * Rank.FIRST_PLACE.getPrizeMoney()
                + placeCount.get(Rank.SECOND_PLACE.getIndex()) * Rank.SECOND_PLACE.getPrizeMoney()
                + placeCount.get(Rank.THIRD_PLACE.getIndex()) * Rank.THIRD_PLACE.getPrizeMoney()
                + placeCount.get(Rank.FOURTH_PLACE.getIndex()) * Rank.FOURTH_PLACE.getPrizeMoney()
                + placeCount.get(Rank.FIFTH_PLACE.getIndex()) * Rank.FIFTH_PLACE.getPrizeMoney();
    }
}