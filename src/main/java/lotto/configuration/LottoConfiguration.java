package lotto.configuration;

public enum LottoConfiguration {
    LOTTO_MAX_NUMBER(45),
    LOTTO_MIN_NUMBER(1),
    LOTTO_NUMBER_COUNT(6),

    LOTTO_PRICE(1000),
    PURCHASE_LIMIT(100_000),
    ;

    static {
        if (LOTTO_MAX_NUMBER.getValue() < LOTTO_MIN_NUMBER.getValue()) {
            throw new IllegalArgumentException("LOTTO_MAX_NUMBER는 LOTTO_MIN_NUMBER보다 작을 수 없습니다.");
        }
        if (LOTTO_NUMBER_COUNT.getValue() < 1) {
            throw new IllegalArgumentException("LOTTO_NUMBER_COUNT는 1보다 작을 수 없습니다.");
        }
        if (LOTTO_PRICE.getValue() <= 0) {
            throw new IllegalArgumentException("LOTTO_PRICE는 0이하의 값을 가질 수 없습니다.");
        }
    }

    private final int value;

    LottoConfiguration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
