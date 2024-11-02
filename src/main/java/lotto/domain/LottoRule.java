package lotto.domain;

public enum LottoRule {
    NUMBER_COUNT(6),
    MAX_NUMBER(45),
    MIN_NUMBER(1);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
