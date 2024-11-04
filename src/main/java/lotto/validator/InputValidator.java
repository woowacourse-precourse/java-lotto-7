package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final String DELIMITER = ",";
    private static final String ERROR_EMPTY = "[ERROR] 입력값이 비어있습니다.";
    private static final String ERROR_NOT_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_NUMBER_COUNT = "[ERROR] 6개의 숫자를 입력해야 합니다.";

    private InputValidator() {
    }

    public static int parsePositiveNumber(String input) {
        validateEmpty(input);
        String trimmedInput = input.trim();
        validateNumeric(trimmedInput);
        return Integer.parseInt(trimmedInput);
    }

    public static List<Integer> parseNumbers(String input) {
        validateEmpty(input);
        String[] values = input.trim().split(DELIMITER);
        validateNumberCount(values);
        return parseNumberList(values);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }

    private static void validateNumberCount(String[] values) {
        if (values.length != 6) {
            throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
        }
    }

    private static void validateNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
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