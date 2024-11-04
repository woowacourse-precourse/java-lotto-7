package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean isBonusMatched;
    private final int prizeMoney;

    Rank(int matchCount, boolean isBonusMatched, int prizeMoney) {
        this.matchCount = matchCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int matchCount, boolean isBonusMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchingCriteria(matchCount, isBonusMatched))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatchingCriteria(int matchCount, boolean isBonusMatched) {
        if (this == SECOND) {
            return this.matchCount == matchCount && this.isBonusMatched == isBonusMatched;
        }
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
