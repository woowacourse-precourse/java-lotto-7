package lotto.common;

public enum LottoConfig {
    LOTTO_PRICE(1000),
    LOTTO_PICK_COUNT(6),
    LOTTO_PURCHASE_LIMIT(100000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    ;
    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
