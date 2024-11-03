package lotto.domain;

public enum WinningResult {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;

    WinningResult(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static WinningResult matchCount(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_BONUS;
        }
        for (WinningResult result : values()) {
            if (result.matchCount == matchCount) {
                return result;
            }
        }
        return null;
    }
}

