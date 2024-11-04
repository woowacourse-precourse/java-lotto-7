package lotto.constant;

public enum LottoEarnings {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000);

    private final int rank;
    private final long earnings;

    LottoEarnings(int rank, long earnings) {
        this.rank = rank;
        this.earnings = earnings;
    }

    public int getRank() {
        return rank;
    }

    public long getEarnings() {
        return earnings;
    }

    public static long getByRank(int rank) {
        for (LottoEarnings earning : values()) {
            if (earning.getRank() == rank) {
                return earning.getEarnings();
            }
        }
        throw new IllegalStateException("[Error] 해당 순위에 대한 수익이 없습니다: " + rank);
    }
}
