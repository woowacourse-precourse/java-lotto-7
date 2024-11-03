package lotto;

public enum LottoRate {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRate(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRate match(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return SIX_MATCH;
        if (matchCount == 5 && bonusMatched) return FIVE_MATCH_WITH_BONUS;
        if (matchCount == 5) return FIVE_MATCH;
        if (matchCount == 4) return FOUR_MATCH;
        if (matchCount == 3) return THREE_MATCH;
        return NONE;
    }
}