package lotto.constant;

public enum LottoNumbersConstant {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBERS_LENGTH(6);

    private final int value;

    LottoNumbersConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
