package lotto.common;

public enum InputRule {
    LOTTO_PRICE(1000);

    private final int value;

    InputRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
