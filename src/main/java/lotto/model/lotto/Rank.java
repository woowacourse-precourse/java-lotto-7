package lotto.model.lotto;

public enum Rank {
    FIRST_PLACE(2_000_000_000, 6, false),

    SECOND_PLACE(30_000_000, 5, true),

    THIRD_PLACE(1_500_000, 5, false),

    FOURTH_PLACE(50_000, 4, false),

    FIFTH_PLACE(5_000, 3, false),

    OUT_OF_RANK(0, 0, false);

    private final int prizeMoney;
    private final int matchingCount;
    private final boolean requiresBonusMatch;

    Rank(int prizeMoney, int matchingCount, boolean requiresBonusMatch) {
        this.prizeMoney = prizeMoney;
        this.matchingCount = matchingCount;
        this.requiresBonusMatch = requiresBonusMatch;
    }

    public static Rank findRank(int matchingCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.isMatchingRank(matchingCount, bonusMatch)) {
                return rank;
            }
        }
        return OUT_OF_RANK;
    }

    private boolean isMatchingRank(int matchingCount, boolean bonusMatch) {
        return this.matchingCount == matchingCount && (isBonusMatchConditionMet(bonusMatch));
    }

    private boolean isBonusMatchConditionMet(boolean bonusMatch) {
        return this.matchingCount != 5 || this.requiresBonusMatch == bonusMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }


    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isRequiresBonusMatch() {
        return requiresBonusMatch;
    }
}
