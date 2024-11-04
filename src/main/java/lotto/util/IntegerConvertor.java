package lotto.util;

import static lotto.constant.ErrorMessage.NOT_INPUT_INTEGER;

public class IntegerConvertor {
    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_INTEGER.getMessage());
        }
    }
}
