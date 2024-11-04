package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;
import static lotto.message.ExceptionMessage.INVALID_NUMBER_INPUT;
import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;

import lotto.exception.IllegalInputException;
import lotto.exception.IllegalTypeException;
import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmountValidator {

    private static final String INPUT = "구입 금액";
    private static final String TYPE = "정수";
    private static final int UNIT = 1000;

    public static int validatePurchaseAmount(String input) {
        validateBlank(input);
        int purchaseAmount = validateType(input);
        validateDivisibleByUnit(purchaseAmount);
        return purchaseAmount;
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalInputException(INVALID_BLANK_INPUT.getMessage());
        }
    }

    private static int validateType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalTypeException(
                    String.format(INVALID_TYPE_INPUT.getMessage(), INPUT, TYPE)
            );
        }
    }

    private static void validateDivisibleByUnit(int input) {
        if (input % UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_INPUT.getMessage(), INPUT, UNIT)
            );
        }
    }
}
