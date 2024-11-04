package lotto.enums;

public enum LottoInfo {
    LOTTO_SIZE(6),
    LOTTO_MIN_LIMIT(1),
    LOTTO_MAX_LIMIT(45),
    LOTTO_PRICE(1000);

    private final int value;

    LottoInfo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
