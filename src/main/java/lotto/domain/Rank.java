package lotto.domain;

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

    public static Rank valueOf(int matchCount, boolean isBonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.isBonusMatched == isBonusMatch) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
