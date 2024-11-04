package lotto.common.config;

public enum Constants {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_NUMBERS_COUNT(6),
    UNIT_PRICE(1000),
    ;

    private final int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
