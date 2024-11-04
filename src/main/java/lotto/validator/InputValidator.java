package lotto.validator;

import lotto.model.ExceptionMessage;

public class InputValidator {

    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final String WIN_NUMBER_PATTERN = "^[0-9,]+$";

    public static void validateSingleNumberInput(String input) {
        validateEmptyInput(input);
        validateNumberFormat(input);
    }

    public static void validateWinNumbers(String input) {
        validateEmptyInput(input);
        if (!input.matches(WIN_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_LIST.getMessage());
        }
    }

    private static void validateEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_VALUE.getMessage());
        }
    }

    private static void validateNumberFormat(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_TYPE.getMessage());
        }
    }
}
