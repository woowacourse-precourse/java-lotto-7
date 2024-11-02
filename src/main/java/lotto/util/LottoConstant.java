package lotto.util;

public enum LottoConstant {

    COST_UNIT(1_000),
    MAX_LOTTERY_COUNT(100),
    LOTTO_NUMBER_START_WITH(1),
    LOTTO_NUMBER_END_WITH(45),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    LottoConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
