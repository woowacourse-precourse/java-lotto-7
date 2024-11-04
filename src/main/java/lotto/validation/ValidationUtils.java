package lotto.validation;

import lotto.constants.ErrorMessageConstants;

public class ValidationUtils {
    private ValidationUtils() {
        throw new IllegalStateException(ErrorMessageConstants.INSTANCE_CREATION_ERROR);
    }

    public static void validateNotBlank(String input, String errorMessage) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateIsNumber(String input, String errorMessage) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
