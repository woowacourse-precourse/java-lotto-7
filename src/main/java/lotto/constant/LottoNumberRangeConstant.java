package lotto.constant;

public enum LottoNumberRangeConstant {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int value;

    LottoNumberRangeConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
