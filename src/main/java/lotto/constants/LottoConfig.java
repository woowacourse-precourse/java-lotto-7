package lotto.constants;

public enum LottoConfig {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_SIZE(6),
    ZERO(0),
    ONE_HUNDRED(100),
    AMOUNT_UNIT(1000);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}