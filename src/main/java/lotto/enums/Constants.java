package lotto.enums;

public enum Constants {
    LOTTO_PRICE(1000),
    LOTTO_START_RANGE(1),
    LOTTO_FINISH_RANGE(45),
    LOTTO_COUNT(6),
    THREE_PRIZE(5000),
    FOUR_PRIZE(50000),
    FIVE_PRIZE(1500000),
    FIVE_BONUS_PRIZE(30000000),
    SIX_PRIZE(2000000000);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
