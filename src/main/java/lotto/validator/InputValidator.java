package lotto.validator;

import lotto.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    public static void validateNumber(String input) {
        String regexp = "^\\d*$";
        if (!Pattern.matches(regexp, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public static void validateWinningNumberFormat(String input) {
        String regexp = "^\\d+(,\\d+)*$";
        if (!Pattern.matches(regexp, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }
}
