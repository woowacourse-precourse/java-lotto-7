package lotto.util;

public enum LottoConfig {
    LOTTO_PRICE(1000),
    LOTTO_MIN(1),
    LOTTO_MAX(45),
    LOTTO_LENGTH(6);
    private final int number;
    LottoConfig(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
