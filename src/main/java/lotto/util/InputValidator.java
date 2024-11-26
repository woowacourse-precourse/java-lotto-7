package lotto.util;

import java.util.Arrays;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class InputValidator {

    private InputValidator() {
    }

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
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_BLANK);
        }
    }

    private static void validateAllInteger(String input) {
        String[] elements = input.split(LottoConstants.WINNING_NUMBER_DELIMITER);
        Arrays.stream(elements).forEach(InputValidator::validateInteger);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INTEGER);
        }
    }
}
