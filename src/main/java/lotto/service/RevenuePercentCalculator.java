package lotto.service;

import java.util.List;
import lotto.util.Constants;
import lotto.util.Ranks;

public class RevenuePercentCalculator {

    private final List<Long> rankCount;

    public RevenuePercentCalculator(List<Long> rankCount) {
        this.rankCount = rankCount;
    }

    public float getRevenuePercent() {
        long revenueSum = 0;
        long moneySpent = rankCount.stream().mapToLong(Long::longValue).sum() * Constants.LOTTO_PRICE.getNumber();

        for (Ranks rank : Ranks.values()) {
            revenueSum += getRevenue(rank);
        }

        return ((float) revenueSum / moneySpent) * 100;
    }

    private long getRevenue(Ranks rank) {
        long count = rankCount.get(rank.getNumber());
        int prize = rank.getPrize();

        return count * prize;
    }


}
