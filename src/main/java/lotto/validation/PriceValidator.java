package lotto.validation;

import enums.Delimiter;
import enums.ErrorMessage;

public class PriceValidator {

    private static final String ERROR_DELIMITER = Delimiter.ERROR.getDelimiter();

    public static void validatePrice(String input) {
        validateNull(input);
    }

    private static void validateNull(String price) {
        if (isNullOrEmpty(price)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
