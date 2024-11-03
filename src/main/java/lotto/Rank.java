package lotto;

public enum Rank {
    FIRST(6, 2000000_000),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchingCount;
    private final int prize;
    private final boolean isBonusMatch;

    Rank(int matchingCount, int prize) {
        this(matchingCount, prize, false);
    }

    Rank(int matchingCount, int prize, boolean isBonusMatch) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.isBonusMatch = isBonusMatch;
    }

    public static Rank findRank(int matchCount, boolean isBonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchingCount == matchCount && (!rank.isBonusMatch || isBonusMatch)) {
                return rank;
            }
        }

        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
