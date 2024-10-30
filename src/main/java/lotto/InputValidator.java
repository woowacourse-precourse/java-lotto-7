package lotto;

import java.util.Arrays;
import lotto.exception.ExceptionMessages;

public class InputValidator {

    private static final String DIGIT_REGEX = "^[0-9]*$";

    public void validateWhiteSpace(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_WHITESPACE.getMessage());
        }
    }

    public void validateNonDigitInput(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_DIGIT.getMessage());
        }
    }

    public void validateOutOfRangeAmount(String input) {
        long amount = Long.parseLong(input);
        if (amount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }
}
