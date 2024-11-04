package lotto.validator;

import lotto.dto.PurchaseAmountDto;
import lotto.exception.PurchaseAmount.*;

public class PurchaseAmountValidator {
    private static final int AMOUNT_UNIT = 1000;
    private static final String REGEX_NUMBER = "^[0-9]+$";

    public static PurchaseAmountDto validate(final String input) {
        validateBlank(input);
        validateNumber(input);
        int convertNumber = convert(input);
        validateNonZero(convertNumber);
        validateMultipleOfThousand(convertNumber);
        return new PurchaseAmountDto(convertNumber / AMOUNT_UNIT);
    }

    private static void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new BlankAmountException();
        }
    }

    private static void validateNumber(final String input) {
        if (!input.matches(REGEX_NUMBER)) {
            throw new NotPositiveNumberException();
        }
    }

    private static void validateNonZero(final int amount) {
        if (amount == 0) {
            throw new ZeroAmountException();
        }
    }

    private static void validateMultipleOfThousand(final int amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new InvalidAmountUnitException();
        }
    }

    private static int convert(String input) {
        return Integer.parseInt(input.replaceAll(" ", ""));
    }
}
