package lotto.validator;

import static lotto.exception.ExceptionMessage.NON_POSITIVE_PURCHASE_AMOUNT;

import java.util.regex.Pattern;

public class PurchaseAmountValidator {
    private static final String POSITIVE_NUMBER_REGEX = "^[1-9][0-9]*$";
    private static final long UNIT_PURCHASE_AMOUNT = 1000L;

    public void validate(String purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
    }

    private void validatePositiveNumber(String purchaseAmount) {
        if (isNonPositiveNumber(purchaseAmount)) {
            throw new IllegalArgumentException(NON_POSITIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isNonPositiveNumber(String purchaseAmount) {
        return !Pattern.matches(POSITIVE_NUMBER_REGEX, purchaseAmount);
    }

    private void
}
