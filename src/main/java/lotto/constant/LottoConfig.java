package lotto.constant;

public enum LottoConfig {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6),

    LOTTO_TICKET_PRICE(1000);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
