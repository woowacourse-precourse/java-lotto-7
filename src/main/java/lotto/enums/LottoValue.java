package lotto.enums;

public enum LottoValue {
    MIN_LOTTO_NUMBER_RANGE(1),
    MAX_LOTTO_NUMBER_RANGE(45),
    NUMBER_COUNT(6),
    LOTTO_PRICE(1000),
    FIVE_MATCHES(5);

    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
