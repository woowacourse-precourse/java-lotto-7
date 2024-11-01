package lotto.common.constant;

public enum LottoConstant {
    LENGTH(6),
    MIN_RANGE(1),
    MAX_RANGE(45);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
