package lotto.application.common.ThousandWons;

import static lotto.application.common.constants.Constants.THOUSAND;
import static lotto.application.common.constants.Constants.ZERO;
import static lotto.application.common.message.Message.SHOULD_MORE_THAN_ZERO;
import static lotto.application.common.message.Message.SHOULD_THOUSAND_UNIT;
import static lotto.application.util.StringConverter.toInt;

public class ThousandWons {

    private final int value;

    public ThousandWons(int value) {
        this.value = value;
    }

    public static ThousandWons of(String money) {
        int value = toInt(money);
        validate(value);

        return new ThousandWons(value);
    }

    public boolean isMuchThanOrEqual(int target) {
        return value >= target;
    }

    public int getValue() {
        return value;
    }

    public int divide(int target) {
        return value / target;
    }

    private static void validate(int value) {
        validatePositive(value);
        validateThousandUnit(value);
    }

    private static void validatePositive(int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException(SHOULD_MORE_THAN_ZERO);
        }
    }

    private static void validateThousandUnit(int value) {
        if (value % THOUSAND != ZERO) {
            throw new IllegalArgumentException(SHOULD_THOUSAND_UNIT);
        }
    }

}

