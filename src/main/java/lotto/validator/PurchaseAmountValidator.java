package lotto.validator;

import static lotto.exception.ExceptionMessage.NON_POSITIVE_PURCHASE_AMOUNT;

import java.util.regex.Pattern;

public class PurchaseAmountValidator {
    private static final String POSITIVE_NUMBER_REGEX = "^[1-9][0-9]*$";

    public void validate(String purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
    }

    private void validatePositiveNumber(String purchaseAmount) {
        if (isNotPositiveNumber(purchaseAmount)) {
            throw new IllegalArgumentException(NON_POSITIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isNotPositiveNumber(String purchaseAmount) {
        return !Pattern.matches(POSITIVE_NUMBER_REGEX, purchaseAmount);
    }
}
