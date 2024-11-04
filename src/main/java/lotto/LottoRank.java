package lotto;

public enum LottoRank {
    FIRST(1, 2_000_000_000L, "6개 일치"),
    SECOND(2, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(3, 1_500_000L, "5개 일치"),
    FOURTH(4, 50_000L, "4개 일치"),
    FIFTH(5, 5_000L, "3개 일치");

    private final int rank;
    private final long prize;
    private final String description;

    LottoRank(int rank, long prize, String description) {
        this.rank = rank;
        this.prize = prize;
        this.description = description;
    }

    public int getRank() {
        return rank;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
