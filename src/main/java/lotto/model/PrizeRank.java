package lotto.model;

import java.util.Arrays;

public enum PrizeRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean isBonusNeed;

    PrizeRank(int matchCount, int prizeAmount, boolean isBonusNeed) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.isBonusNeed = isBonusNeed;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static PrizeRank getPrizeRank(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(prizeRank -> (prizeRank.matchCount == matchCount))
                .filter(prizeRank -> (!prizeRank.isBonusNeed || isBonusMatch))
                .findFirst()
                .orElse(NONE);
    }
}
