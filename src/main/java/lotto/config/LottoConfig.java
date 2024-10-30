package lotto.config;

public enum LottoConfig {
    LOTTO_MAX_NUMBER(45),
    LOTTO_MIN_NUMBER(1),
    LOTTO_NUMBER_COUNT(6),
    ;

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
