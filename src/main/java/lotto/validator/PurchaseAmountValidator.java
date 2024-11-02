package lotto.validator;

import static lotto.message.CommonConstants.MINIMUM_AMOUNT;
import static lotto.message.CommonConstants.ZERO;
import static lotto.message.ErrorMessage.ERROR_INPUT_PURCHASE_AMOUNT;
import static lotto.message.ErrorMessage.ERROR_INVALID_UNIT;
import static lotto.message.ErrorMessage.ERROR_NEGATIVE_PRICE;

import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmountValidator {

    public static void validateInputPurchaseAmount(String inputPurchaseAmount) {
        validateBlankInput(inputPurchaseAmount);
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        validateNegativeAmount(purchaseAmount);
        validateInvalidUnit(purchaseAmount);
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

}
