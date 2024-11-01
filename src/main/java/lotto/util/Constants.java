package lotto.util;

public enum Constants {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_SIZE(6),
    ZERO(0),
    DELIMITER(",");

    private final Integer intValue;
    private final String stringValue;

    Constants(int intValue) {
        this.intValue = intValue;
        this.stringValue = null;
    }

    Constants(String stringValue) {
        this.intValue = null;
        this.stringValue = stringValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}