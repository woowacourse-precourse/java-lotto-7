package lotto.util;

public enum Constants {
    LOTTO_PRICE(1000),
    MAX_MONEY(1000000000), // 10억, Long.MAX_VALUE 보단 작게
    MIN_MONEY(1),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private final long number;

    Constants(long number) {
        this.number = number;
    }

    public long getLong() {
        return number;
    }

    public int getNumber() {
        return (int) number;
    }
}
