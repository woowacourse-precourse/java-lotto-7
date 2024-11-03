package lotto.enums;

public enum Constants {
    PURCHASE_AMOUNT_MINIMUM(1_000),
    PURCHASE_AMOUNT_UNIT(1_000),
    PURCHASE_AMOUNT_MAXIMUM(Integer.MAX_VALUE),
    LOTTO_NUMBER_MINIMUM(1),
    LOTTO_NUMBER_MAXIMUM(45),
    WINNING_NUMBER_COUNT(6),
    ZERO_VALUE(0);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
