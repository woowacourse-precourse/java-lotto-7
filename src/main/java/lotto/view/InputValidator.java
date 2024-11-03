package lotto.view;

import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.NOT_MULTIPLE_OF_UNIT_PRICE;

import lotto.common.exception.EmptyInputException;
import lotto.common.exception.InvalidInputException;

public class InputValidator {
    private static final int unitPrice = 1000;
    private static final String numericPattern = "\\d+";

    public void validatePurchaseAmount(String purchaseAmount) {
        if (isEmptyInput(purchaseAmount)) {
//            throw new IllegalArgumentException(EMPTY_INPUT.getMessages());
            throw new EmptyInputException();
        }
        if (!isNumeric(purchaseAmount)) {
            throw new InvalidInputException(NONE_NUMERIC_INPUT.getMessages());
        }
        if (!isIntegerRange(purchaseAmount)) {
//            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE.getMessages());
            throw new InvalidInputException(NONE_NUMERIC_INPUT.getMessages());
        }
        if (!isMultipleOfUnitPrice(purchaseAmount)) {
            throw new InvalidInputException(NOT_MULTIPLE_OF_UNIT_PRICE.getMessages());
        }
    }

    private boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isNumeric(String input) {
        return input.matches(numericPattern);
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
