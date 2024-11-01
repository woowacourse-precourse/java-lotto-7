package lotto.validator;

import static lotto.message.ErrorMessage.ERROR_BELOW_MINIMUM;
import static lotto.message.ErrorMessage.ERROR_INPUT_PURCHASE_AMOUNT;
import static lotto.message.ErrorMessage.ERROR_INVALID_UNIT;
import static lotto.message.ErrorMessage.ERROR_NEGATIVE_PRICE;
import static lotto.message.MessageConstants.MINIMUM_AMOUNT;
import static lotto.message.MessageConstants.ZERO;

import lotto.util.ParseUtil;
import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmountValidator {

    public static void validatePurchaseAmount(String purchaseAmount) {
        validateBlankInput(purchaseAmount);
        int amount = ParseUtil.parseInt(purchaseAmount);
        validateNegativeAmount(amount);
        validateInvalidUnit(amount);
        validateBelowMinimumAmount(amount);
    }

    private static void validateBlankInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ERROR_INPUT_PURCHASE_AMOUNT);
        }
    }

    private static void validateNegativeAmount(int amount) {
        if (amount < ZERO) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_PRICE);
        }
    }

    private static void validateInvalidUnit(int amount) {
        if (amount % MINIMUM_AMOUNT != ZERO) {
            throw new IllegalArgumentException(ERROR_INVALID_UNIT);
        }
    }

    private static void validateBelowMinimumAmount(int amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(ERROR_BELOW_MINIMUM);
        }
    }

}
