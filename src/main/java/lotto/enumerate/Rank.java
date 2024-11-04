package lotto.enumerate;

public enum Rank {
    FIRST(2000000000, 1, "6개 일치 (2,000,000,000원)"),
    SECOND(30000000, 2, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1500000, 3, "5개 일치 (1,500,000원)"),
    FOURTH(50000, 4, "4개 일치 (50,000원)"),
    FIFTH(5000, 5, "3개 일치 (5,000원)"),
    NONE(0, 6, "");
    private final long prize;
    private final int rank;
    private final String rankPrintSentence;

    Rank(long prize, int rank, String correctNumber) {
        this.prize = prize;
        this.rank = rank;
        this.rankPrintSentence = correctNumber;
    }

    public String getRankPrintSentence() {
        return rankPrintSentence;
    }

    public long getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }
}
