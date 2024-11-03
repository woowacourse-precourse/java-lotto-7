package lotto.utility;

public enum LottoPrizeEnum {
    THREE_MATCHED_PRIZE (5000),
    FOUR_MATCHED_PRIZE(50000),
    FIVE_MATCHED_PRIZE(1500000),
    FIVE_WITH_BONUS_MATCHED_PRIZE(30000000),
    SIX_MATCHED_PRIZE(2000000000);

    private final int amount;

    LottoPrizeEnum(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}