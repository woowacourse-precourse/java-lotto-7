package lotto.validator;

import static lotto.constant.ErrorCode.INVALID_INPUT_FORMAT;

public class InputFormatValidator {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }
}
