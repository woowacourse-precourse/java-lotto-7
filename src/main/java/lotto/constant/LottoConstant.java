package lotto.constant;

public enum LottoConstant {

    LOTTO_NUMBER_UPPER_BOUND(45),
    LOTTO_NUMBER_LOWER_BOUND(1),
    NUMBER_OF_LOTTO_NUMBERS(6),
    MONEY_UNIT(1000);

    private final int number;

    LottoConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
