package lotto.constant;

public enum LottoNumbersValidatorConstant {
    LOTTO_NUMBERS_LENGTH(6);

    private final int value;

    LottoNumbersValidatorConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
