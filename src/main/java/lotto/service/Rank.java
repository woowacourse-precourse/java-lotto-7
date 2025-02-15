package lotto.service;

public enum Rank {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000),
    NONE(0, 0);

    private final int rank;
    private final int prize;

    Rank(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank fromRank(int rank) {
        for (Rank r : Rank.values()) {
            if (r.rank == rank) {
                return r;
            }
        }
        return NONE;
    }
}
