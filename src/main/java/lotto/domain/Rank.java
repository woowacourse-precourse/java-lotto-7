package lotto.domain;

public enum Rank {
    NO_MATCH(0, false, 0),
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    Rank(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank from(int matchCount, boolean hasBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.hasBonus == hasBonus) {
                return rank;
            }
        }
        return NO_MATCH;
    }
}
