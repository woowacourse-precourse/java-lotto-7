package lotto.util;

import java.util.Arrays;

public class InputValidator {

    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final int WINNING_NUMBER_SIZE = 6;

    public static void validatePurchaseAmount(String input) {
        InputValidator.validateNotBlank(input);
        InputValidator.validateInteger(input);
    }

    public static void validateWinningNumbers(String input) {
        validateNotBlank(input);
        validateDelimitedFormat(input);
        validateAllNumbers(input);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어 있지 않아야 합니다.");
        }
    }

    private static void validateDelimitedFormat(String input) {
        String[] elements = input.split(WINNING_NUMBER_DELIMITER);
        if (elements.length != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력값은 쉼표(,)로 구분된 6개의 숫자여야 합니다.");
        }
    }

    private static void validateAllNumbers(String input) {
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
