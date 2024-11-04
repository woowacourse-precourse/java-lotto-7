package lotto.model.enums;

public enum LottoConstants {
    LOTTO_TICKET_PRICE(1000),
    LOTTO_NUMBERS_SIZE(6),
    LOTTO_BEGIN_NUMBER(1),
    LOTTO_END_NUMBER(45),
    NUMBER_OF_LOTTO_PRIZE(6),
    HALF_UP_ROUNDING_POSITION(1);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
