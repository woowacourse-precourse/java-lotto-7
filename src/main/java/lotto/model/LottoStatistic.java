package lotto.model;

import lotto.enums.Rank;

import java.util.Map;

public class LottoStatistic {
    private final Map<Rank, Integer> rankCount;
    private final double returnRate;

    public LottoStatistic(Map<Rank, Integer> rankCount, double returnRate) {
        this.rankCount = rankCount;
        this.returnRate = returnRate;
    }

    public double getReturnRate() {
        return returnRate;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }
}
