package lotto.constant;

public enum LottoRank {
    NO_WINNER(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusNumberMatch;

    LottoRank(int matchCount, int prizeMoney, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusNumberMatch = false;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean getBonusNumberMatch() {
        return bonusNumberMatch;
    }

    public static LottoRank getLottoRank(int matchCount, boolean bonusNumberMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount && rank.getBonusNumberMatch() == bonusNumberMatch) {
                return rank;
            }
        }
        return NO_WINNER;
    }
}
