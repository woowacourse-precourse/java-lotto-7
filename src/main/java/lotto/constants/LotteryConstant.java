package lotto.constants;

public enum LotteryConstant {
    TICKET_PRICE(1000),
    LOTTO_NUMBERS_COUNT(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LotteryConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

