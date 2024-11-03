package lotto.view.input;

import static lotto.common.Exceptions.*;

public class InputValidator {
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
    private static final int INTEGER_RANGE_LENGTH = 10;

    public static void validateGeneralValueInput(String generalValue) {
        if (generalValue == null
                || generalValue.isBlank()) {
            throw new IllegalArgumentException(EMPTY_VALUE.getMessage());
        }
    }

    public static void validateInputInteger(String integerInput) {
        validateGeneralValueInput(integerInput);
        if (!integerInput.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER.getMessage());
        }
        if (integerInput.length() > INTEGER_RANGE_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE.getMessage());
        }
    }
}
