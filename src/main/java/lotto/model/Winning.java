package lotto.model;

import java.util.Arrays;

public enum Winning {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean isBonusNumberMatched;
    private final long prizeMoney;

    Winning(int matchCount, boolean isBonusNumberMatched, long prizeMoney) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prizeMoney = prizeMoney;
    }

    public static Winning getRank(int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(Winning.values())
                .filter(winning -> (matchCount != 5 || winning.isBonusNumberMatched == isBonusNumberMatched)
                        && winning.matchCount == matchCount)
                .findFirst()
                .orElse(Winning.NONE);
    }

    public long prizeMoney() {
        return prizeMoney;
    }
}
