package lotto;

public enum LottoRank {
    FIRST(1, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(2, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(3, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(5, 5_000, "3개 일치 (5,000원) - ");

    private final int rank;
    private final int prize;
    private final String message;

    LottoRank(int rank, int prize, String message) {
        this.rank = rank;
        this.prize = prize;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }


}
