package lotto;

public enum PrizeRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);  // 당첨되지 않은 경우

    public final int matchCount;
    public final boolean bonusMatch;
    public final int prizeAmount;

    PrizeRank(int matchCount, boolean bonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusMatch() {
        return bonusMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static PrizeRank getRank(int matchCount, boolean bonusMatch) {
        for (PrizeRank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}
