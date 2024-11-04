package lotto.util;

import static lotto.message.ErrorMessage.EMPTY_OR_BLANK;
import static lotto.message.ErrorMessage.INVALID_FORMAT;

public class Parse {

    private static final String INTEGER_REGEX = "-?\\d+";

    public Integer StringToInteger(String input) {
        validate(input.trim());
        return Integer.parseInt(input.trim());
    }

    private void validate(String input) {
        validateBlank(input);
        validateFormat(input);
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_OR_BLANK.getMessage());
        }
    }

    private void validateFormat(String input) {
        if (!input.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }
}
