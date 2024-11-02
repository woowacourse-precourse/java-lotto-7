package lotto.contants.value;

public enum LottoValue {
    PRICE_UNIT(1000),
    MIN_LOTTO_NUM(1),
    MAX_LOTTO_NUM(45),
    RANK_FIRST_PRIZE(2000000000),
    RANK_SECOND_PRIZE(30000000),
    RANK_THRID_PRIZE(1500000),
    RANK_FOURTH_PRIZE(50000),
    RANK_FIFTH_PRIZE(5000);

    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
