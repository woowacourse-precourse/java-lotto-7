package lotto.model;

public enum PrizeTier {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeAmount;

    PrizeTier(int matchCount, boolean bonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public static PrizeTier getPrizeTier(int matchCount, boolean bonusMatch) {
        for (PrizeTier tier : values()) {
            if (tier.matchCount == matchCount && tier.bonusMatch == bonusMatch) {
                return tier;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
