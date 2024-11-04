package lotto.enums;

public enum IntEnum {
    WINNING_BONUS_NUMBERS(45),
    NOT_MATCH_BONUS_NUMBERS(34),
    THREE_MATCH_PRIZE(5000),
    FOUR_MATCH_PRIZE(50000),
    FIVE_MATCH_PRIZE(1500000),
    FIVE_WITH_BONUS_MATCH_PRIZE(30000000),
    SIX_MATCH_PRIZE(2000000000),
    ;

    private final int number;

    IntEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
