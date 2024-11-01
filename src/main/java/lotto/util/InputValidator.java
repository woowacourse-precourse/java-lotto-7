package lotto.util;

import java.util.Arrays;

public class InputValidator {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static void validateNotBlankAndInteger(String input) {
        InputValidator.validateNotBlank(input);
        InputValidator.validateInteger(input);
    }

    public static void validateWinningNumbers(String input) {
        validateNotBlank(input);
        validateAllInteger(input);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어 있지 않아야 합니다.");
        }
    }

    private static void validateAllInteger(String input) {
        String[] elements = input.split(WINNING_NUMBER_DELIMITER);
        Arrays.stream(elements).forEach(InputValidator::validateInteger);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수여야 합니다.");
        }
    }
}
