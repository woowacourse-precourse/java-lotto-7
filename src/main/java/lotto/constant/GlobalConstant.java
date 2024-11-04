package lotto.constant;

public enum GlobalConstant {

    INIT_VAL(0);

    private final int value;

    GlobalConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
