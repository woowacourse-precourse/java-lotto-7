package lotto.common;

public enum Rule {
    MINIMUM_RANGE_NUMBER(1),
    MAXIMUM_RANGE_NUMBER(45),
    NUMBER_COUNT(6),
    LOTTO_PRICE(1000),
    ROUND_COUNT(2);

    private final int number;

    Rule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
