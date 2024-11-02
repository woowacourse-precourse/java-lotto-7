package lotto.validator;

import static lotto.exception.ExceptionMessage.BLANK_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.NON_POSITIVE_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.NOT_DIVIDED_BY_UNIT_AMOUNT;

import java.util.regex.Pattern;
import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmountValidator {
    private static final String POSITIVE_NUMBER_REGEX = "^[1-9][0-9]*$";
    public static final long UNIT_PURCHASE_AMOUNT = 1000L;

    public void validate(String purchaseAmount) {
        validateBlank(purchaseAmount);
        validatePositiveNumber(purchaseAmount);
        validateDivisibleByUnitAmount(purchaseAmount);
    }

    private void validateBlank(String purchaseAmount) {
        if (StringUtils.isBlank(purchaseAmount)) {
            throw new IllegalArgumentException(BLANK_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validatePositiveNumber(String purchaseAmount) {
        if (isNonPositiveNumber(purchaseAmount)) {
            throw new IllegalArgumentException(NON_POSITIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isNonPositiveNumber(String purchaseAmount) {
        return !Pattern.matches(POSITIVE_NUMBER_REGEX, purchaseAmount);
    }

    private void validateDivisibleByUnitAmount(String purchaseAmount) {
        if (isNotDividedByUnitAmount(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_UNIT_AMOUNT.getMessage());
        }
    }

    private boolean isNotDividedByUnitAmount(String purchaseAmount) {
        return !(Long.parseLong(purchaseAmount) % UNIT_PURCHASE_AMOUNT == 0);
    }
}
