package lotto.model;

public enum LottoIntConst {
    MIN_LOTTO_NUM(1),
    MAX_LOTTO_NUM(45),
    LOTTO_SIZE(6),
    PRICE(1_000);

    private final int value;

    LottoIntConst(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
