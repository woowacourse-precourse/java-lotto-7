package lotto.validation;

import lotto.enums.ErrorMessage;

public class LottoNumberValidator {

    public static void validateLottoNumber(String input) {
        validateNull(input);
        validateSeparatorNotComma(input);
        validateSeparatorContinue(input);
        validateNoEmptyBetweenCommas(input);
        validateSixNumbers(input);
        validateStartWithZero(input);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateSeparatorNotComma(String input) {
        if (!input.contains(",") || !input.matches("^[\\d,\\s]+$")) {
            throw new IllegalArgumentException(ErrorMessage.SEPARATOR_NOT_COMMA.getErrorMessage());
        }
    }

    private static void validateSeparatorContinue(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_SEPARATOR_CONTINUE.getErrorMessage());
        }
    }

    private static void validateNoEmptyBetweenCommas(String input) {
        String [] values = input.split(",");

        for (String value : values) {
            if (value.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NUMBER_BLANK.getErrorMessage());
            }
        }
    }

    private static void validateSixNumbers(String input) {
        String [] values = input.split(",");

        if (values.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INPUT_SIX_NUMBERS.getErrorMessage());
        }
    }

    private static void validateStartWithZero(String input) {
        String [] values = input.split(",");

        for (String value : values) {
            value = value.trim();
            if (value.startsWith("0")) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_START_WITH_ZERO.getErrorMessage());
            }
        }
    }
}
