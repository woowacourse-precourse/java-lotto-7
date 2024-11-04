package lotto.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String DELIMITER = ",";
    private static final int MAX_INPUT_LENGTH = 100;
    private static final String VALID_NUMBER_PATTERN = "^[0-9]+$";

    private static final String ERROR_EMPTY = "[ERROR] 입력값이 비어있습니다.";
    private static final String ERROR_NOT_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_NUMBER_COUNT = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String ERROR_INVALID_INPUT = "[ERROR] 유효하지 않은 입력값입니다.";
    private static final String ERROR_INPUT_TOO_LONG = "[ERROR] 입력이 너무 깁니다.";

    private InputValidator() {
    }

    public static int parsePositiveNumber(String input) {
        validateEmpty(input);
        validateInputLength(input);
        validateNoSpecialCharacters(input);
        String trimmedInput = input.trim();
        validateNumeric(trimmedInput);
        return Integer.parseInt(trimmedInput);
    }

    public static List<Integer> parseNumbers(String input) {
        validateEmpty(input);
        validateInputLength(input);
        validateNoSpecialCharacters(input);
        String[] values = input.trim().split(DELIMITER);
        validateNumberCount(values);
        return parseNumberList(values);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }

    private static void validateInputLength(String input) {
        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(ERROR_INPUT_TOO_LONG);
        }
    }

    private static void validateNoSpecialCharacters(String input) {
        if (containsSpecialCharacters(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }

    private static boolean containsSpecialCharacters(String input) {
        return input.matches(".*[<>\\\\;'\"].*") ||
                input.contains("script") ||
                input.matches(".*[\\x00-\\x1F\\x7F].*");
    }

    private static void validateNumberCount(String[] values) {
        if (values.length != 6) {
            throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
        }
    }

    private static void validateNumeric(String value) {
        if (!Pattern.matches(VALID_NUMBER_PATTERN, value)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private static List<Integer> parseNumberList(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            String trimmedValue = value.trim();
            validateNumeric(trimmedValue);
            numbers.add(Integer.parseInt(trimmedValue));
        }
        return numbers;
    }
}