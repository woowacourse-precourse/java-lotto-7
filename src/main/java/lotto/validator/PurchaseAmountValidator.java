package lotto.validator;

import static lotto.constants.CommonConstants.MAX_PURCHASE_AMOUNT;
import static lotto.constants.CommonConstants.POSITIVE_NUMBER_REGEX;
import static lotto.constants.CommonConstants.UNIT_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.BLANK_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.EXCEEDS_MAX_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.NON_POSITIVE_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.NOT_DIVIDED_BY_UNIT_AMOUNT;

import java.util.regex.Pattern;
import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmountValidator {

    public static void validate(String purchaseAmount) {
        validateBlank(purchaseAmount);
        validatePositiveNumber(purchaseAmount);
        validateDivisibleByUnitAmount(purchaseAmount);
        validateExceedsMaxPurchaseAmount(purchaseAmount);
    }

    private static void validateBlank(String purchaseAmount) {
        if (StringUtils.isBlank(purchaseAmount)) {
            throw new IllegalArgumentException(BLANK_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validatePositiveNumber(String purchaseAmount) {
        if (isNonPositiveNumber(purchaseAmount)) {
            throw new IllegalArgumentException(NON_POSITIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean isNonPositiveNumber(String purchaseAmount) {
        return !Pattern.matches(POSITIVE_NUMBER_REGEX, purchaseAmount);
    }

    private static void validateDivisibleByUnitAmount(String purchaseAmount) {
        if (isNotDividedByUnitAmount(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_UNIT_AMOUNT.getMessage());
        }
    }

    private static boolean isNotDividedByUnitAmount(String purchaseAmount) {
        return !(Long.parseLong(purchaseAmount) % UNIT_PURCHASE_AMOUNT == 0);
    }

    private static void validateExceedsMaxPurchaseAmount(String purchaseAmount) {
        if (exceedsMaxPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException(EXCEEDS_MAX_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean exceedsMaxPurchaseAmount(String purchaseAmount) {
        return Long.parseLong(purchaseAmount) > MAX_PURCHASE_AMOUNT;
    }
}
