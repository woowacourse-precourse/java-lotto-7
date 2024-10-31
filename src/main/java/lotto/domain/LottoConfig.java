package lotto.domain;

public enum LottoConfig {
    MINIMUM(1),
    MAXIMUM(45),
    PRICE(1_000),
    SIZE(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
