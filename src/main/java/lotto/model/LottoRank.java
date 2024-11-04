package lotto.model;

public enum LottoRank {
    FIRST(1, "6개 일치", 2000000000),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30000000),
    THIRD(3, "5개 일치", 1500000),
    FOURTH(4, "4개 일치", 50000),
    FIFTH(5, "3개 일치", 5000),
    NONE(0, "꽝", 0);

    private final int rank;
    private final String description;
    private final int prize;

    LottoRank(int rank, String description, int prize) {
        this.rank = rank;
        this.description = description;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}
