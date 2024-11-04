package lotto.model;

public enum LottoWinnerPrize {
    FIRST_PRIZE(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH_PRIZE(3, 5000, "3개 일치 (5,000원) - ");

    private final int numberOfCount;
    private final int prize;
    private final String description;

    LottoWinnerPrize(int numberOfCount, int prize, String description) {
        this.numberOfCount = numberOfCount;
        this.prize = prize;
        this.description = description;
    }

    public int getNumberOfCount() {
        return numberOfCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

}