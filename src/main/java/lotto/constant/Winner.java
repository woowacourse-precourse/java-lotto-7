package lotto.constant;

public enum Winner {
    FIRST_WINNER(1, 6, 2000000000),
    SECOND_WINNER(2, 6, 30000000),
    THIRD_WINNER(3, 5, 1500000),
    FOURTH_WINNER(4, 4, 50000),
    FIFTH_WINNER(5, 3, 5000);

    private final int rank;
    private final int matchCount;
    private final long prizeMoney;

    Winner(final int rank, final int matchCount, final long prizeMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
