package lotto.validator;

import lotto.enums.ExceptionMessage;

import java.util.regex.Pattern;

public interface Validator {
    Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    default void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_BLANK.getMessage());
        }
    }

    default void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NON_NUMERIC.getMessage());
        }
    }

    default void validateNonZeroStart(String input) {
        if (input.startsWith("0")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ZERO_START.getMessage());
        }
    }

    void validate(String input);
}
