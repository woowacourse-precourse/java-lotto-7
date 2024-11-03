package lotto;

public enum Rank {

    FIRST(6, 2000000000, 1, false),
    SECOND(5, 30000000, 2, true),
    THIRD(5, 1500000, 3, false),
    FOURTH(4, 50000, 4, false),
    FIFTH(3, 5000, 5, false);

    private final int count;
    private final int prize;
    private final int rank;
    private final boolean needsBonus;

    Rank(int count, int prize, int rank, boolean needsBonus) {
        this.count = count;
        this.prize = prize;
        this.rank = rank;
        this.needsBonus = needsBonus;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

    public boolean isNeedsBonus() {
        return needsBonus;
    }
}
