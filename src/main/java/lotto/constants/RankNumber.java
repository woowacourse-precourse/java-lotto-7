package lotto.constants;

public enum RankNumber {
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    FIRST_PRIZE_MONEY(2000000000),
    SECOND_PRIZE_MONEY(30000000),
    THIRD_PRIZE_MONEY(1500000),
    FOURTH_PRIZE_MONEY(50000),
    FIFTH_PRIZE_MONEY(5000);

    private final int number;

    RankNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
