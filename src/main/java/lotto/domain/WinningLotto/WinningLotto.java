package lotto.domain.WinningLotto;

public enum WinningLotto {
    NO_MATCH(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchedCount;
    private final long prize;

    WinningLotto(int matchedCount, long prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getPrize() {
        return prize;
    }

    public static WinningLotto from(int matchedCount, boolean hasBonus) {
        if (matchedCount == SIX_MATCH.matchedCount) {
            return SIX_MATCH;
        }
        if (matchedCount == FIVE_MATCH.matchedCount) {
            return hasBonus ? FIVE_MATCH_BONUS : FIVE_MATCH;
        }
        if (matchedCount == FOUR_MATCH.matchedCount) {
            return FOUR_MATCH;
        }
        if (matchedCount == THREE_MATCH.matchedCount) {
            return THREE_MATCH;
        }
        return NO_MATCH;
    }
}
