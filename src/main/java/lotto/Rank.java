package lotto;

public enum Rank {

    FIRST_PLACE(6, false),
    SECOND_PLACE(5, true),
    THIRD_PLACE(5, false),
    FORTH_PLACE(4, false),
    FIFTH_PLACE(3, false),
    NONE(0, false);

    private int matchCount;
    private boolean requiredBonusNumber;

    Rank(int matchCount, boolean requiredBonusNumber) {
        this.matchCount = matchCount;
        this.requiredBonusNumber = requiredBonusNumber;
    }

    public static Rank findRankByMatchCount(int matchCount, boolean matchedBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.requiredBonusNumber == matchedBonusNumber) {
                return rank;
            }
        }
        return NONE;

    }
}
