package lotto.util;

public enum ConstantVariable {
    LOTTO_PRICE(1000),
    ;

    private final int value;

    ConstantVariable(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
