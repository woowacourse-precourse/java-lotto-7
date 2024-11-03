package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int winningAmount;
    private final boolean requiresBonus;

    Rank(int matchCount, int winningAmount) {
        this(matchCount, winningAmount, false);
    }

    Rank(int matchCount, int winningAmount, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.requiresBonus = requiresBonus;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.requiresBonus || hasBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    public int getWinnings() {
        return winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}