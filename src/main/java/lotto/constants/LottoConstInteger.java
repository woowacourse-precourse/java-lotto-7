package lotto.constants;

public enum LottoConstInteger {
    LOTTO_PRICE(1000),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_WINNING_NUMBER_COUNT(6),
    BONUS_NUMBER_COUNT(1),

    ;
    private final int value;

    LottoConstInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
