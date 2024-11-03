package lotto.models.constants;

public enum LottoValues {
    TICKET_PRICE(1000),
    PURCHASE_CAP(100000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_SIZE(6);

    private final int value;

    LottoValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
