package lotto.model;

public enum LottoRank {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000),
    NO_MATCH(0, false, 0);  // 기본값, 일치하지 않는 경우

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoRank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return NO_MATCH;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
