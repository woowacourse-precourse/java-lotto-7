package lotto.enums;

public enum LottoConfig {
    LOTTO_NUM_SIZE(6),
    LOTTO_NUM_START(1),
    LOTTO_NUM_END(45),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
