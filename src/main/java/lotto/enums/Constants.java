package lotto.enums;

public enum Constants {
    LOTTO_PRICE(1000),
    LOTTO_START_RANGE(1),
    LOTTO_FINISH_RANGE(45),
    LOTTO_COUNT(6);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
