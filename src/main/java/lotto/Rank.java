package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int matchCount;
    private final boolean isBonusNumberMatched;
    private final int prizeMoney;

    Rank(int matchCount, boolean isBonusNumberMatched, int prizeMoney) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf (int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(values())
                .filter(rank -> matchCount == rank.matchCount)
                .filter(rank -> isBonusNumberMatched == rank.isBonusNumberMatched)
                .findFirst()
                .orElse(null);
    }
}
