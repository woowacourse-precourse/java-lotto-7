package lotto;

public enum LottoPrize {
    FIFTH("3개 일치 (5,000원)", 5_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000);

    private final String description;
    private final int prize;

    LottoPrize(String rank, int prize) {
        this.description = rank;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public String toString() {
        return description + " - ";
    }
}
