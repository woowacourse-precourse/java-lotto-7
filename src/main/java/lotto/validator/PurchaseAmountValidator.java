package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;
import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;

import lotto.exception.IllegalInputException;
import lotto.exception.IllegalTypeException;
import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmountValidator {

    private static final String input = "구입 금액";
    private static final String type = "정수";
    private static final int unit = 1000;

    public static int validatePurchaseAmount(String input) {
        validateBlank(input);
        int purchaseAmount = validateType(input);
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
                    String.format(INVALID_TYPE_INPUT.getMessage(), input, type)
            );
        }
    }
}
