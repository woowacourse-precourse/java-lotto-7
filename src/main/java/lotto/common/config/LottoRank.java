package lotto.common.config;

public enum LottoRank {
    MATCH_6(6, false, 2_000_000_000),
    MATCH_5_BONUS(5, true, 30_000_000),
    MATCH_5(5, false, 1_500_000),
    MATCH_4(4, false, 50_000),
    MATCH_3(3, false, 5_000),
    ;

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoRank(int matchCount, boolean bonusMatch, int prize) {
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
}
