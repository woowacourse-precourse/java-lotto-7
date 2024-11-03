package lotto.constant;

public enum WinningRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    WinningRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public Integer getMatchCount() {
        return this.matchCount;
    }

    public Integer getPrize() {
        return this.prize;
    }

    public static WinningRank valueOf(int rank, boolean isBonus) {
        if (rank == 6) {
            return FIRST;
        }
        if (rank == 5 && isBonus) {
            return SECOND;
        }
        if (rank == 5) {
            return THIRD;
        }
        if (rank == 4) {
            return FOURTH;
        }
        if (rank == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
