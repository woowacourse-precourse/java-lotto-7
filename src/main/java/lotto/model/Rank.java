package lotto.model;

public enum Rank {

    NO_WIN(0, BonusRequirement.IRRELEVANT, 0, false),
    FIFTH_PLACE(3, BonusRequirement.IRRELEVANT, 5000, true),
    FOURTH_PLACE(4, BonusRequirement.IRRELEVANT, 50000, true),
    THIRD_PLACE(5, BonusRequirement.IRRELEVANT, 1500000, true),
    SECOND_PLACE(5, BonusRequirement.REQUIRED, 30000000, true),
    FIRST_PLACE(6, BonusRequirement.IRRELEVANT, 2000000000, true);

    private final int matchCount;
    private final BonusRequirement bonusRequirement;
    private final int prize;
    private final boolean isWinning;

    Rank(final int matchCount, final BonusRequirement bonusRequirement, final int prize, final boolean isWinning) {
        this.matchCount = matchCount;
        this.bonusRequirement = bonusRequirement;
        this.prize = prize;
        this.isWinning = isWinning;
    }

    public static Rank valueOf(final int matchCount, final boolean hasBonus) {
        if (matchCount == FIRST_PLACE.matchCount) {
            return FIRST_PLACE;
        }
        if (matchCount == SECOND_PLACE.matchCount && hasBonus) {
            return SECOND_PLACE;
        }
        if (matchCount == THIRD_PLACE.matchCount) {
            return THIRD_PLACE;
        }
        if (matchCount == FOURTH_PLACE.matchCount) {
            return FOURTH_PLACE;
        }
        if (matchCount == FIFTH_PLACE.matchCount) {
            return FIFTH_PLACE;
        }
        return NO_WIN;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BonusRequirement getBonusRequirement() {
        return bonusRequirement;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isWinning() {
        return isWinning;
    }

    public enum BonusRequirement {
        REQUIRED, IRRELEVANT
    }
}
