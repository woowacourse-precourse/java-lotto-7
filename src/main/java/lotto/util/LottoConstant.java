package lotto.util;

public enum LottoConstant {
    LOTTO_PURCHASE_AMOUNT(1000),
    LOTTO_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    DELIMITER(",");

    private final String value;

    LottoConstant(int value) {
        this.value = String.valueOf(value);
    }

    LottoConstant(String value) {
        this.value = value;
    }

    public int getIntValue() {
        return Integer.parseInt(value);
    }

    public String getValue() {
        return value;
    }
}