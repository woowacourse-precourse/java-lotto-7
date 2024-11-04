package lotto.constant;

public enum LottoNumberRule {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    FIXED_SIZE(6);

    private final int value;

    LottoNumberRule(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
