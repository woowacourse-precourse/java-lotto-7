package lotto;

public enum MatchResult {
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    MatchResult(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    public static MatchResult valueOf(int matchCount, boolean bonusMatch) {
        for (MatchResult result : values()) {
            if (result.matchCount == matchCount && result.bonusMatch == bonusMatch) {
                return result;
            }
        }
        return null; // 일치하는 결과가 없는 경우
    }
}
