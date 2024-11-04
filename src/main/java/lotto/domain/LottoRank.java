package lotto.domain;

public enum LottoRank {
    NOT_MATCH(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank getRank(int matchCount, boolean hasBonus) {
        if (matchCount == 3) {
            return LottoRank.THREE_MATCH;
        }
        if (matchCount == 4) {
            return LottoRank.FOUR_MATCH;
        }
        if (matchCount == 5) {
            if (hasBonus) {
                return LottoRank.FIVE_MATCH_WITH_BONUS;
            }
            return LottoRank.FIVE_MATCH;
        }
        if (matchCount == 6) {
            return LottoRank.SIX_MATCH;
        }
        return LottoRank.NOT_MATCH;
    }
}
