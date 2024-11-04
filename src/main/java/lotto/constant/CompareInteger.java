package lotto.constant;

public enum CompareInteger {
    PRICE_LOTTO(1000),
    PRICE_MINIMUM(1000),
    PRICE_MAXIMUM(100000),
    ZERO(0),
    ONE(1),
    LOTTO_NUMBER_MINIMUM(1),
    LOTTO_NUMBER_MAXIMUM(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_MATCHING_COUNT_SECOND_PLACE(5),
    PRIZE_FIFTH(5000),
    PRIZE_FOURTH(50000),
    PRIZE_THIRD(1500000),
    PRIZE_SECOND(30000000),
    PRIZE_FIRST(2000000000);

    private final Integer number;

    CompareInteger(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}