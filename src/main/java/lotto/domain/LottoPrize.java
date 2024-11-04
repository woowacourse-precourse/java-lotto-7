package lotto.domain;

public enum LottoPrize {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000),
    NONE(0, 0);

    private final int rank;
    private final int prize;

    LottoPrize(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public static int getPrize(int rank) {
        for (LottoPrize lottoPrize : values()) {
            if (lottoPrize.rank == rank) {
                return lottoPrize.prize;
            }
        }
        return NONE.prize;
    }
}