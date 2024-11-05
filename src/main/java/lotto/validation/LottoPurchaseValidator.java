package lotto.validation;

import static lotto.util.LottoConstants.DEFAULT;
import static lotto.util.LottoConstants.LOTTO_PRICE;
import static lotto.util.LottoConstants.ZERO_THRESHOLD;

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
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InputErrorMessage.INTEGER_REQUIRED);
        }
    }

    private static void validatePositiveNumber(String input) {
        if (Long.parseLong(input) < ZERO_THRESHOLD.getValue()) {
            throw new InvalidInputException(InputErrorMessage.POSITIVE_NUMBER_REQUIRED);
        }
    }

    private static void validatePurchaseUnit(String input) {
        if (Long.parseLong(input) % LOTTO_PRICE.getValue() != DEFAULT.getValue()) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_PURCHASE_MUST_BE_MULTIPLE_OF_THOUSAND);
        }
    }
}
