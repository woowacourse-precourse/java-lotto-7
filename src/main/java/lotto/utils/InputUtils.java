package lotto.utils;

import static lotto.constant.ErrorMessage.NOT_NUMBER_FORMAT_ERROR_MESSAGE;

public class InputUtils {
    private InputUtils() {
    }

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
        }
    }
}
