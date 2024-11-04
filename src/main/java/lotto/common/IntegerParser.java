package lotto.common;

import static lotto.common.ExceptionMessage.INVALID_NUMBER_FORMAT;

public class IntegerParser {
    public static int parseToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
