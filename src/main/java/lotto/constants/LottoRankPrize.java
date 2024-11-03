package lotto.constants;

public enum LottoRankPrize {
    FIRST(1, 200000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NONE(-1, 0);

    private final int rank;
    private final int prize;

    LottoRankPrize(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}

