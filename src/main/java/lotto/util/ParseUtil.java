package lotto.util;

import static lotto.message.ErrorMessage.ERROR_NON_NUMERIC_INPUT;

public class ParseUtil {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT);
        }
    }

}
