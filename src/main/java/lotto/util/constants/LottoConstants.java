package lotto.util.constants;

public enum LottoConstants {

    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_SIZE(6),
    PER_AMOUNT(1000),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
