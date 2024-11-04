package lotto;

public enum WinningRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean requiresBonus;

    WinningRank(int matchCount, int prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public static WinningRank valueOf(int matchCount, boolean bonusMatch) {
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        return null;
    }
}
