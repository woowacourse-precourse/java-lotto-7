package lotto.util.validator;

import static lotto.util.Constants.ERROR_PREFIX;

public class NumericValidator {
    private static final String INVALID_NUMBER_ERROR_MESSAGE = ERROR_PREFIX + "해당 입력은 숫자여야 합니다.";

    public static void validate(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }
    }

    private static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
