package lotto.util.validator;

import lotto.exception.InputErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator {
    private final static String NUMBER_RANGE_PATTERN = "([1-9]|[1-3][0-9]|4[0-5])(,[1-9]|[1-3][0-9]|4[0-5])*";
    private final static String SPLIT_DELIMITER = ",";
    private final static int LOTTO_NUMBER_SIZE = 6;

    private WinningNumbersValidator() {}

    public static void validateWinningNumbers(String input) {
        validateNotEmpty(input);
        validateNumericFormat(input);
        validateSizeSix(input);
        validateDuplicates(input);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumericFormat(String input) {
        if (!input.matches(NUMBER_RANGE_PATTERN)) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_WINNING_RANGE.getMessage());
        }
    }

    private static void validateSizeSix(String input) {
        List<String> numbers = Arrays.asList(input.split(SPLIT_DELIMITER));
        if (!(numbers.size() == LOTTO_NUMBER_SIZE)) {
            throw new IllegalArgumentException(InputErrorMessage.OVER_SIZE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateDuplicates(String input) {
        List<String> numbers = Arrays.asList(input.split(SPLIT_DELIMITER));
        Set<String> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(InputErrorMessage.DUPLICATED_WINNING_NUMBER.getMessage());
        }
    }
}

