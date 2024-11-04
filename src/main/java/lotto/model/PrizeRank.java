package lotto.model;

public enum PrizeRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingNumbers;
    private final boolean requiresBonus;
    private final int prizeAmount;

    PrizeRank(int matchingNumbers, boolean requiresBonus, int prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.requiresBonus = requiresBonus;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    // Determine the prize rank based on matching numbers and bonus match
    public static PrizeRank valueOf(int matchCount, boolean bonusMatch) {
        for (PrizeRank rank : values()) {
            if (rank.matchingNumbers == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        for (PrizeRank rank : values()) {
            if (rank.matchingNumbers == matchCount && !rank.requiresBonus) {
                return rank;
            }
        }
        return null;
    }
}
