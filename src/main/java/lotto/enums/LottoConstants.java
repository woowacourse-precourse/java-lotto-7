package lotto.enums;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    PAYMENT_AMOUNT(13000),
    EXPECTED_LOTTO_COUNT(13);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
