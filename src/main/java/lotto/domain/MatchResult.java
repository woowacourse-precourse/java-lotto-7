package lotto.domain;

public enum MatchResult {
    SIX_MATCH(2000000000),
    FIVE_MATCH_AND_BONUS(30000000),
    FIVE_MATCH(1500000),
    FOUR_MATCH(50000),
    THREE_MATCH(5000),
    NO_MATCH(0);

    private final int prize;

    MatchResult(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static MatchResult from(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return SIX_MATCH;
        }
        if (matchCount == 5 && hasBonus) {
            return FIVE_MATCH_AND_BONUS;
        }
        if (matchCount == 5) {
            return FIVE_MATCH;
        }
        if (matchCount == 4) {
            return FOUR_MATCH;
        }
        if (matchCount == 3) {
            return THREE_MATCH;
        }
        return NO_MATCH;
    }
}
