package lotto.constant;

public enum LottoNumbersValidatorConstant {
    MIN_LOTTO_NUMBER(0),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBERS_LENGTH(6);

    private final int value;

    LottoNumbersValidatorConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
