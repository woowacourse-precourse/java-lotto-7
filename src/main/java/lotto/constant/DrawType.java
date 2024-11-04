package lotto.constant;

import java.util.Objects;

public enum DrawType {

    THREE_MATCH("3"),
    FOUR_MATCH("4"),
    FIVE_MATCH_WITHOUT_BONUS("5"),
    FIVE_MATCH_WITH_BONUS("5B"),
    SIX_MATCH("6"),
    NO_MATCH("0");

    private String value;

    DrawType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public boolean matches(String result, boolean hasBonusResult) {
        if (hasBonusResult) {
            return this.equals(FIVE_MATCH_WITH_BONUS);
        }
        return Objects.equals(this.value, result);
    }
}
