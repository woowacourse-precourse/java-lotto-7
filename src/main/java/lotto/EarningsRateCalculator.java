package lotto;

import lotto.enums.Prize;
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
        return placeCount.get(Rank.FIRST_PLACE_INDEX.getValue()) * Prize.FIRST_PLACE.getMoney()
                + placeCount.get(Rank.SECOND_PLACE_INDEX.getValue()) * Prize.SECOND_PLACE.getMoney()
                + placeCount.get(Rank.THIRD_PLACE_INDEX.getValue()) * Prize.THIRD_PLACE.getMoney()
                + placeCount.get(Rank.FOURTH_PLACE_INDEX.getValue()) * Prize.FOURTH_PLACE.getMoney()
                + placeCount.get(Rank.FIFTH_PLACE_INDEX.getValue()) * Prize.FIFTH_PLACE.getMoney();
    }
}