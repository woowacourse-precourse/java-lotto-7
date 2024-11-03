package lotto.model.domain;

import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class InputValidator {

    private static final String JUST_NUMBER_PATTERN_REGEX = "^[0-9]+$";
    private static final String WINNING_NUMBER_PATTERN_REGEX = "^[0-9,]+$";
    private static final String SEPARATOR = ",";
    private static final String INVALID_SEPARATOR_PATTERN = ",,";

    public void validateInputAmount(String input) {
        validateEmptyOf(input);
        validateInvalidCharacterOf(input, ExceptionMessage.INVALID_AMOUNT_CHARACTER_INPUT_EXCEPTION);
        int amount = validateExceedMaxAreaOf(input);
        validateMinAmountOf(amount);
        validateAmountUnitOf(amount);
    }

    public void validateInputWinningNumber(String input) {
        validateEmptyOf(input);
        validateWinningNumberCharacterOf(input);
        validateFormatOf(input);
        validateSeparatedNumberOf(input);
    }

    public void validateInputBonusNumber(String input) {
        validateEmptyOf(input);
        validateInvalidCharacterOf(input, ExceptionMessage.INVALID_BONUS_NUMBER_CHARACTER_INPUT_EXCEPTION);
    }

    private void validateEmptyOf(String input) {
        boolean isEmpty = input == null || input.isEmpty();
        if (isEmpty) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT_EXCEPTION);
        }
    }

    private void validateInvalidCharacterOf(String input, String message) {
        if (!Pattern.matches(JUST_NUMBER_PATTERN_REGEX, input)) {
            throw new IllegalArgumentException(message);
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
