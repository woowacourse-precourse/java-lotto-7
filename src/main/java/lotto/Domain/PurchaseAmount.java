package lotto.Domain;

import lotto.Messages.ErrorMessage;
import lotto.Utils.Validator;

public class PurchaseAmount {
    private int value = 0;

    public PurchaseAmount(String input) {
        validateInput(input);
    }

    private static void validateInput(String input) {
        checkEmpty(input);
        checkBlank(input);
        checkNumeric(input);
    }

    private static void checkEmpty(String input) {
        if (Validator.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkBlank(String input) {
        if (Validator.isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkNumeric(String input) {
        if (Validator.isNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT.getMessage());
        }
    }

}
