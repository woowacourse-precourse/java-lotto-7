package lotto.constants;

public enum Constants {
    LOTTO_LENGTH(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    ZERO(0),
    ONE_THOUSAND(1000),
    FIVE_THOUSAND(5000),
    FIFTY_THOUSAND(50000),
    ONE_MILLION_FIVE_HUNDRED_THOUSAND(1500000),
    THIRTY_MILLION(30000000),
    TWO_BILLION(2000000000);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
