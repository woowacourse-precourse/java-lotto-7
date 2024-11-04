package lotto.constant;

public enum LottoValue {
    LOTTO_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBERS_LENGTH(6),
    LOTTO_RANK_GRADE(6);

    private int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
