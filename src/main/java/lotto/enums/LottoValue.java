package lotto.enums;

public enum LottoValue {
    MAX_RANGE_NUMBER(45),
    MIN_RANGE_NUMBER(1),
    PRICE_PER_LOTTO(1000);

    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
