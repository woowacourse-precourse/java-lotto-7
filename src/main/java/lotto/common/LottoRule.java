package lotto.common;

public enum LottoRule {
    LOTTO_PRICE(1000);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
