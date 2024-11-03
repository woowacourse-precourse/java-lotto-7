package lotto.domain;

public enum Rank {
    NO_MATCH(0, false, Prize.NO_MATCH),
    THREE_MATCH(3, false, Prize.THREE_MATCH),
    FOUR_MATCH(4, false, Prize.FOUR_MATCH),
    FIVE_MATCH(5, false, Prize.FIVE_MATCH),
    FIVE_MATCH_WITH_BONUS(5, true, Prize.FIVE_MATCH_WITH_BONUS),
    SIX_MATCH(6, false, Prize.SIX_MATCH);

    private final int matchCount;
    private final boolean hasBonus;
    private final Prize prize;

    Rank(int matchCount, boolean hasBonus, Prize prize) {
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

    public Prize getPrize() {
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
