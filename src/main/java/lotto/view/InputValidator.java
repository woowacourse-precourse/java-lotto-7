package lotto.view;

import static lotto.constant.ErrorMessage.INVALID_NON_NUMERIC_INPUT;
import static lotto.constant.ErrorMessage.INVALID_NULL_OR_BLANK;

import java.util.Arrays;

public class InputValidator {

    private static final String COMMA = ",";

    protected static void validateNotNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NULL_OR_BLANK.getMessage());
        }
    }

    protected static void validateIsNumeric(String input) {
        String[] numbers = splitInput(input);
        Arrays.stream(numbers)
                .forEach(InputValidator::validateNumberIsNumeric);
    }

    private static String[] splitInput(String input) {
        return input.split(COMMA);
    }

    private static void validateNumberIsNumeric(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_NON_NUMERIC_INPUT.getMessage());
        }
    }
}
