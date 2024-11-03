package lotto.constants;

public enum LottoValue {

    MIN_LOTTO_NUMBER_RANGE(1),
    MAX_LOTTO_NUMBER_RANGE(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}