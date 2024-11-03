package lotto.domain;

public enum LottoConfig {
    LOTTO_START(1),
    LOTTO_END(45),
    LOTTO_NUMBER_LIMIT(6);

    private final int unit;

    LottoConfig(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
