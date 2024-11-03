package lotto.validator.strategy;

import lotto.exception.custom.NotPositiveIntegerException;
import lotto.validator.InputValidator;

public class PurchaseAmountValidator implements InputValidator {

    private static final String INTEGER_PATTERN = "\\d+";

    @Override
    public void validate(String input) {
        if (!isPositiveInteger(input)) {
            throw new NotPositiveIntegerException();
        }
    }

    private boolean isPositiveInteger(String inputPurchaseAmount) {
        return inputPurchaseAmount.matches(INTEGER_PATTERN);
    }
}
