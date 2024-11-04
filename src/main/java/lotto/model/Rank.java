package lotto.model;

public enum Rank {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    NONE(0, false, 0L);

    private final int matched;
    private final boolean bonusRequired;
    private final long prize;

    Rank(int matched, boolean bonusRequired, long prize) {
        this.matched = matched;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatched) {
        for (Rank rank : values()) {
            if (rank.matched == matchCount && rank.bonusRequired == bonusMatched) {
                return rank;
            }
        }
        return NONE;
    }

    public long calculate(int count) {
        return count * prize;
    }
}
