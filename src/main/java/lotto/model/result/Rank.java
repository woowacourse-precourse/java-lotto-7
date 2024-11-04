package lotto.model.result;

public enum Rank {
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    FIVE_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;

    Rank(int matchCount, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return null;
    }
}
