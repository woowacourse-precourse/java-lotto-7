package lotto.util;

import static lotto.constant.LottoConstants.*;
import static lotto.exception.ExceptionMessage.*;
public class InputUtil {

    public static void validateEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    public static void validatePositiveInteger(String input){
        String trimmedInput = input.trim();

        if (trimmedInput.startsWith(NEGATIVE_SIGN) || STRING_ZERO.equals(trimmedInput) || trimmedInput.contains(DECIMAL_POINT)) {
            throw new IllegalArgumentException(ONLY_POSITIVE_INPUT.getMessage());
        }
        if (!trimmedInput.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage());
        }
    }

}
