package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> ranks;
    private final double profitRate;
    private static final int FIRST_PRIZE = 1;
    private static final int SECOND_PRIZE = 2;
    private static final int THIRD_PRIZE = 3;
    private static final int FOURTH_PRIZE = 4;
    private static final int FIFTH_PRIZE = 5;

    public LottoResult(Map<Integer, Integer> ranks, double profitRate) {
        this.ranks = ranks;
        this.profitRate = profitRate;
    }

    public Map<Integer, Integer> getRanks() {
        return ranks;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public int getFirstPrizeCount() {
        return ranks.getOrDefault(FIRST_PRIZE, 0);
    }

    public int getSecondPrizeCount() {
        return ranks.getOrDefault(SECOND_PRIZE, 0);
    }

    public int getThirdPrizeCount() {
        return ranks.getOrDefault(THIRD_PRIZE, 0);
    }

    public int getFourthPrizeCount() {
        return ranks.getOrDefault(FOURTH_PRIZE, 0);
    }

    public int getFifthPrizeCount() {
        return ranks.getOrDefault(FIFTH_PRIZE, 0);
    }
}
