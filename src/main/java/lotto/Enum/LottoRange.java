package lotto.Enum;

public enum LottoRange {
    LOTTO_LOWEST_NUMBER(1),
    LOTTO_HIGHEST_NUMBER(46);

    private final int value;

    LottoRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
