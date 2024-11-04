package lotto.constant;

public enum Rank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000),
    NO_MATCH(0, 0);

    private final int matchCount;
    private final long winnings;

    Rank(int matchCount, long winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinnings() {
        return winnings;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        if (matchCount == SIX_MATCH.getMatchCount()) {
            return SIX_MATCH;
        }
        if (matchCount == FIVE_MATCH.getMatchCount()) {
            return getRankForFiveMatches(hasBonus);
        }
        if (matchCount == FOUR_MATCH.getMatchCount()) {
            return FOUR_MATCH;
        }
        if (matchCount == THREE_MATCH.getMatchCount()) {
            return THREE_MATCH;
        }
        return NO_MATCH;
    }

    private static Rank getRankForFiveMatches(boolean hasBonus) {
        if (hasBonus) {
            return FIVE_MATCH_BONUS;
        }
        return FIVE_MATCH;
    }
}
