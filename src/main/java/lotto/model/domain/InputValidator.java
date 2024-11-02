package lotto.model.domain;

import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class InputValidator {

    private static final String AMOUNT_PATTERN_REGEX = "^[0-9]+$";
    private static final String WINNING_NUMBER_PATTERN_REGEX = "^[0-9,]+$";
    private static final String SEPARATOR = ",";
    private static final String INVALID_SEPARATOR_PATTERN = ",,";

    public void validateInputAmount(String input) {
        validateEmptyOf(input);
        validateInvalidCharacterOf(input);
        int amount = validateExceedMaxAreaOf(input);
        validateMinAmountOf(amount);
        validateAmountUnitOf(amount);
    }

    private void validateEmptyOf(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT_EXCEPTION);
        }
    }

    private void validateInvalidCharacterOf(String input) {
        if (!Pattern.matches(AMOUNT_PATTERN_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CHARACTER_INPUT_EXCEPTION);
        }
    }

    private int validateExceedMaxAreaOf(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEED_MAX_AREA_EXCEPTION);
        }
    }

    private void validateMinAmountOf(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(ExceptionMessage.UNDER_MIN_AMOUNT_INPUT_EXCEPTION);
        }
    }

    private void validateAmountUnitOf(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_UNIT_EXCEPTION);
        }
    }

    public void validateInputWinningNumber(String input) {
        validateEmptyOf(input);
        validateWinningNumberCharacterOf(input);
        validateFormatOf(input);
        validateSeparatedNumberOf(input);
    }

    private void validateWinningNumberCharacterOf(String input) {
        if (!Pattern.matches(WINNING_NUMBER_PATTERN_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_CHARACTER_INPUT_EXCEPTION);
        }
    }

    private void validateFormatOf(String input) {
        boolean isInvalidFormat = input.endsWith(SEPARATOR) || input.startsWith(SEPARATOR);
        if (isInvalidFormat) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT_EXCEPTION);
        }
    }

    private void validateSeparatedNumberOf(String input) {
        if (input.contains(INVALID_SEPARATOR_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SEPARATOR_NUMBER_EXCEPTION);
        }
    }

}
