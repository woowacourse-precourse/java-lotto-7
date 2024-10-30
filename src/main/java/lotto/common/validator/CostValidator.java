package lotto.common.validator;

import lotto.error.CostErrorMessage;
import java.util.regex.Pattern;

public class CostValidator {
    private static final String NUMBER_CHECK_REGEX = "^[0-9]+$";

    public static void validate(String strCost) {
        checkNumber(strCost);
        int cost = Integer.parseInt(strCost);
        checkMinimumPrice(cost);
        checkMaximumPrice(cost);
        checkCanDivided(cost);
    }

    private static void checkCanDivided(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(CostErrorMessage.CAN_NOT_DIVIDED
                    .getMessage());
        }
    }

    private static void checkMinimumPrice(int cost) {
        if (cost < 1000) {
            throw new IllegalArgumentException(CostErrorMessage.INSUFFICIENT_MONEY
                    .getMessage());
        }
    }

    private static void checkMaximumPrice(int cost) {
        if (cost > 1_000_000) {
            throw new IllegalArgumentException(CostErrorMessage.TOO_MANY_MONEY
                    .getMessage());
        }
    }

    private static void checkNumber(String cost) {
        if (!isNumber(cost)) {
            throw new IllegalArgumentException(CostErrorMessage.IS_NOT_NUMBER
                    .getMessage());
        }
    }

    private static boolean isNumber(String cost) {
        return Pattern.matches(NUMBER_CHECK_REGEX, cost);
    }
}
