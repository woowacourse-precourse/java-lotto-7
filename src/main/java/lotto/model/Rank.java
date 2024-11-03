package lotto.model;

public enum Rank {
    FIFTH(0, 5000, 3),
    FOURTH(1, 50000, 4),
    THIRD(2, 1500000, 5),
    SECOND(3, 30000000, 5),
    FIRST(4, 2000000000, 6);

    private final int index;
    private final int prize;
    private final int matchCount;

    Rank(int index, int prize, int matchCount) {
        this.index = index;
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getIndex() {
        return index;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank getRank(int matchingCount, boolean hasBonus) {
        if (matchingCount == 6) return FIRST;
        if (matchingCount == 5) return hasBonus ? SECOND : THIRD;
        if (matchingCount == 4) return FOURTH;
        if (matchingCount == 3) return FIFTH;
        return null;
    }
}
