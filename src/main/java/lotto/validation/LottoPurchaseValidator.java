package lotto.validation;

import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class LottoPurchaseValidator {
    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateIsInteger(input);
        validatePositiveNumber(input);
        validatePurchaseUnit(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(InputErrorMessage.CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InputErrorMessage.POSITIVE_NUMBER_REQUIRED);
        }
    }

    private static void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new InvalidInputException(InputErrorMessage.POSITIVE_NUMBER_REQUIRED);
        }
    }

    private static void validatePurchaseUnit(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_PURCHASE_MUST_BE_MULTIPLE_OF_THOUSAND);
        }
    }
}
