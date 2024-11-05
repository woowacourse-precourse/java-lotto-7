package lotto.validation;

import lotto.util.MessageSource;

public class ValidatorUtil {

    public static void validateNumericInput(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.invalid_number_format"));
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }
}
