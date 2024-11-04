package content;

public enum LottoPrize {
    FIRST(2000000000, "6개 일치 (2,000,000,000원) - "),
    SECONDS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(50000, "4개 일치 (50,000원) - "),
    FIFTH(5000, "3개 일치 (5,000원) - "),
    WINNING_RESULT_TITLE(0,"당첨 통계");


    private final int amount;
    private final String description;

    LottoPrize(int amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
