package lotto.Validator;

import static lotto.error.ErrorCode.*;

import java.util.List;

public class InputValidator {

    public static void validateInput(String input) {
        validateNullOrBlank(input);
        validateNumeric(input);
    }

    public static void validateNumbers(List<String> numbers) {
        numbers.forEach(InputValidator::validateNullOrBlank);
        numbers.forEach(InputValidator::validateNumeric);
    }

    public static void validateNullOrBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_INPUT.getMessage());
        }
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT.getMessage());
        }
    }

}
