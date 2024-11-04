package lotto.util;

public enum Grade {
    FIFTH(3, false, 5000),
    FORTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchingCount;
    private final boolean isBonusMatch;
    private final Integer prizeMoney;

    Grade(int matchingCount, boolean isBonusMatch, Integer prizeMoney) {
        this.matchingCount = matchingCount;
        this.isBonusMatch = isBonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}
