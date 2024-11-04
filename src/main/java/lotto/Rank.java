package lotto;

public enum Rank {
    FIRST(6, 0),
    SECOND(5, 1),
    THIRD(5, 0),
    FOURTH(4, 0),
    FIFTH(3, 0),
    MISS(-1, 0);

    private final int numberCount;
    private final int bounsExist;

    Rank(int numberCount, int bounsExist) {
        this.numberCount = numberCount;
        this.bounsExist = bounsExist;
    }

    public static Rank checkRank(int numberCount, int bounsExist) {
        for (Rank rank : Rank.values()) {
            if (rank.numberCount == numberCount && rank.bounsExist == bounsExist) {
                return rank;
            }
        }
        return MISS;
    }
}