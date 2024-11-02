package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class InputValidator {

    private static final String AMOUNT_PATTERN_REGEX = "^[0-9]+$";
    private static final String WINNING_NUMBER_PATTERN_REGEX = "^[0-9,]+$";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
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

    public List<Integer> validateInputWinningNumber(String input) {
        validateEmptyOf(input);
        validateWinningNumberCharacterOf(input);
        validateFormatOf(input);
        validateSeparatedNumberOf(input);
        return createNumbers(input);
    }

    private List<Integer> createNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> forValidateDuplication = new HashSet<>();
        for (String separatedInput : input.split(SEPARATOR)) {
            int number = Integer.parseInt(separatedInput);
            validateNumberAreaOf(number);
            validateNumberDuplication(forValidateDuplication, number);
            numbers.add(number);
        }
        return numbers;
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

    private void validateNumberAreaOf(int number) {
        boolean isInvalidNumberArea = number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
        if (isInvalidNumberArea) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_AREA_EXCEPTION);
        }
    }

    private void validateNumberDuplication(Set<Integer> forValidateDuplication, int number) {
        boolean isDuplicated = !forValidateDuplication.add(number);
        if (isDuplicated) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_DUPLICATION_EXCEPTION);
        }
    }

}
