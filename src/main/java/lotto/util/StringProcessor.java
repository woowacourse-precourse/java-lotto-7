package lotto.util;

import static lotto.constant.ErrorMessage.EMPTY_INPUT_ERROR;
import static lotto.constant.ErrorMessage.NULL_INPUT_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_RANGE_ERROR;

public class StringProcessor {
    public static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR.getMessage());
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
    }

    public static String removeCommas(String input) {
        return input.replaceAll(",", "");
    }

    public static int integerConverter(String input) {
        try {
            int number = Integer.parseInt(input);

            if (number < 1) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
