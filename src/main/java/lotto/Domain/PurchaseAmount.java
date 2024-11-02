package lotto.Domain;

import lotto.Messages.ErrorMessage;
import lotto.Utils.Parser;
import lotto.Utils.Validator;

public class PurchaseAmount {
    private final int value;

    private PurchaseAmount(int value) {
        this.value = value;
    }

    public static PurchaseAmount from(String input) {
        validateInput(input);
        int value = Parser.stringToInteger(input);
        validateValue(value);
        return new PurchaseAmount(value);
    }

    private static void validateInput(String input) {
        checkEmpty(input);
        checkBlank(input);
        checkNumeric(input);
        checkInteger(input);
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

    private static void checkInteger(String input) {
        if (!Validator.isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_OUT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateValue(int value) {
        checkPositive(value);
    }

    private static void checkPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getValue() {
        return value;
    }

}
