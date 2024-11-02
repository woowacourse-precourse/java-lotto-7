package lotto.domain;

public enum LottoPrize {

    FIRST_PRIZE("6개 일치 (2,000,000,000원)", 2_000_000_000, 1),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 2),
    THIRD_PRIZE("5개 일치 (1,500,000원)", 1_500_000, 3),
    FOURTH_PRIZE("4개 일치 (50,000원)", 50_000, 4),
    FIFTH_PRIZE("3개 일치 (5,000원)", 5_000, 5),
    NO_PRIZE("0개 일치", 0, 6);

    private String description;
    private long price;
    private int rank;

    LottoPrize(String description, long price, int rank) {
        this.description = description;
        this.price = price;
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }

    public int getRank() {
        return rank;
    }
}
