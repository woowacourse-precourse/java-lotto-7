package lotto.Util.Constant;

public enum GeneralConstants {
    TICKET_PRICE(1000),
    PRIZE_3_MATCH(5000),
    PRIZE_4_MATCH(50000),
    PRIZE_5_MATCH(1500000),
    PRIZE_5_MATCH_WITH_BONUS(30000000),
    PRIZE_6_MATCH(2000000000),
    PERCENT_CONVERSION(100);

    private final int value;

    GeneralConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
