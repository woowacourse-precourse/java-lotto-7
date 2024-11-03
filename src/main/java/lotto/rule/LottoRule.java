package lotto.rule;

public enum LottoRule {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBERS_COUNT(6),
    PURCHASE_AMOUNT_UNIT(1_000),
    MIN_PURCHASE_QUANTITY(1),
    ;

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    public static boolean isValidRange(int number) {
        return MIN_LOTTO_NUMBER.value <= number
                && number <= MAX_LOTTO_NUMBER.value;
    }
}
