package lotto.utils;

public enum LottoCriteria {
    FIRST(6, 2_000_000_000, 1),
    SECOND(5, 30_000_000, 2),
    THIRD(5, 1_500_000, 3),
    FOURTH(4, 50_000, 4),
    FIFTH(3, 5_000, 5),
    NONE(0, 0, 6);

    private final int matchCount;
    private final int prize;
    private final int rank;

    LottoCriteria(int matchCount, int prize, int rank) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.rank = rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }
}
