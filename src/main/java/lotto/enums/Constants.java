package lotto.enums;

public enum Constants {

    MONEY_UNIT(1_000),

    LOTTO_NUMBER_SIZE(6),
    LOTTO_LOWER_BOUND(1),
    LOTTO_UPPER_BOUND(45),
    ;

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
