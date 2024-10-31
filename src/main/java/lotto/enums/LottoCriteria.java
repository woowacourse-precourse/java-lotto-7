package lotto.enums;

public enum LottoCriteria {

    BUY_MONEY_UNIT(1000),
    WINNING_NUMBER_COUNT(6),
    BONUS_CASE_SPECIAL_LOTTO_NUM(7),
    MAX_LOTTO_COUNT(1000),
    MIN_LOTTO_COUNT(1),
    MIN_WIN_COUNT(3),
    MAX_LOTTO_NUM(45),
    MIN_LOTTO_NUM(1),
    BONUS_LOTTO_NUM(5),

    BONUS_NUMBER_SIZE(1)
    ;

    private final int criteriaVal;

    LottoCriteria(int criteriaVal) {
        this.criteriaVal = criteriaVal;
    }

    public int getCriteriaVal() {
        return criteriaVal;
    }
}
