package lotto.configuration;

public enum LottoConfiguration {
    LOTTO_MAX_NUMBER(45),
    LOTTO_MIN_NUMBER(1),
    LOTTO_NUMBER_COUNT(6),

    LOTTO_PRICE(1000),
    PURCHASE_LIMIT(100_000),
    ;

    private final int value;

    LottoConfiguration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
