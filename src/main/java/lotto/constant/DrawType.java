package lotto.constant;

import java.util.Objects;

public enum DrawType {

    THREE_MATCH("3", 5000),
    FOUR_MATCH("4", 50000),
    FIVE_MATCH_WITHOUT_BONUS("5", 1500000),
    FIVE_MATCH_WITH_BONUS("5B", 30000000),
    SIX_MATCH("6", 2000000000),
    NO_MATCH("0", 0);

    private final String value;
    private final int prize;

    DrawType(String value, int prize) {
        this.value = value;
        this.prize = prize;
    }

    public String getValue() {
        return this.value;
    }

    public int getPrize() {
        return this.prize;
    }

    public boolean matches(String result, boolean hasBonusResult) {
        if (hasBonusResult) {
            return this.equals(FIVE_MATCH_WITH_BONUS);
        }
        return Objects.equals(this.value, result);
    }
}
