package lotto.constant;

public enum LottoGameRule {
    LOTTO_COST(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    NUMBER_OF_PICKS(6);

    private final int value;

    LottoGameRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
