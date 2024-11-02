package lotto.view;

import static lotto.view.ExceptionMessages.NOT_MULTIPLE_OF_UNIT_PRICE;
import static lotto.view.ExceptionMessages.OUT_OF_INTEGER_RANGE;

public class InputValidator {
    private static final int unitPrice = 1000;

    public void validatePurchaseAmount(String purchaseAmount) {
        if (!isIntegerRange(purchaseAmount)) {
            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE.getMessages());
        }
        if (!isMultipleOfUnitPrice(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_UNIT_PRICE.getMessages());
        }
    }

    private boolean isIntegerRange(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isMultipleOfUnitPrice(String input) {
        return Integer.parseInt(input) % unitPrice == 0;
    }
}
