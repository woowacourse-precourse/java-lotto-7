package lotto.common.constant;

public enum LottoIntegerConstant {

    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),

    LOTTO_NUMBER_LOWER_BOUND(1),
    LOTTO_NUMBER_UPPER_BOUND(45);

    private final int number;

    LottoIntegerConstant(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
