package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private final boolean requiresBonus;

    Rank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    Rank(int matchCount, int prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                if (rank.requiresBonus == bonusMatch) {
                    return rank;
                }
                if (!rank.requiresBonus) {
                    return rank;
                }
            }
        }
        return NONE;
    }
}

