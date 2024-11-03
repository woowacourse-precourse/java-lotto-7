package lotto.model;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchingCount;
    private final int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank determineRank(int matchingCount, boolean hasBonus) {
        if (matchingCount == FIRST.matchingCount) return FIRST;
        if (matchingCount == SECOND.matchingCount && hasBonus) return SECOND;
        if (matchingCount == THIRD.matchingCount) return THIRD;
        if (matchingCount == FOURTH.matchingCount) return FOURTH;
        if (matchingCount == FIFTH.matchingCount) return FIFTH;
        return NONE;
    }

}