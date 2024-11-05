package lotto.enumerate;

public enum LottoPrizeEnum {
    THREE_MATCHED (5000, "3개 일치 (5,000원)"),
    FOUR_MATCHED(50000, "4개 일치 (50,000원)"),
    FIVE_MATCHED(1500000, "5개 일치 (1,500,000원)"),
    FIVE_WITH_BONUS_MATCHED(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCHED(2000000000, "6개 일치 (2,000,000,000원)");

    private final int amount;
    private final String message;

    LottoPrizeEnum(int amount, String message) {
        this.amount = amount;
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }
}