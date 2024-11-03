package lotto.constant;

public enum NumberType {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_COUNT(6),
    LOTTO_PRICE_UNIT(1000),
    MIN_PURCHASE_COUNT(1);


    private final int number;

    NumberType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
