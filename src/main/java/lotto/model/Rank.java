package lotto.model;


public enum Rank {

    NONE(2, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);


    public final int duplicatedCount;
    public final int reward;

    Rank(int duplicatedCount, int reward) {
        this.duplicatedCount = duplicatedCount;
        this.reward = reward;
    }

    public static Rank from(int duplicateCount, boolean isBonusNumberDuplicated) {
        if (duplicateCount == 5) {
            if (isBonusNumberDuplicated) {
                return SECOND;
            }
            return THIRD;
        }
        for (Rank rank : Rank.values()) {
            if (rank.duplicatedCount == duplicateCount) {
                return rank;
            }
        }
        return NONE;
    }
}
