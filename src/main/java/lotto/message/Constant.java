package lotto.message;

public enum Constant {
    LOTTO_SIX_MATCHES(6),

    LOTTO_FIVE_MATCHES(5),

    LOTTO_FOUR_MATCHES(4),

    LOTTO_THREE_MATCHES(3),

    RANK_EXTRACT_NUMBER(8),

    NO_RANK(0),

    FIRST_PRIZE_MONEY(2000000000),

    SECOND_PRIZE_MONEY(30000000),

    THIRD_PRIZE_MONEY(1500000),

    FOURTH_PRIZE_MONEY(50000),

    FIFTH_PRIZE_MONEY(5000),

    MONEY_CONVERSION(1000),

    LOTTO_COUNT(6);


    private final int constant;

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
