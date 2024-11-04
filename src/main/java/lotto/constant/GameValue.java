package lotto.constant;

public enum GameValue {
    NUMBER_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    DIVIDE_FOR_TICKET_COUNT_NUMBER(1000),
    MIN_BUYING_AMOUNT(0),
    PERCENTAGE(100);

    private final Integer value;

    GameValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
