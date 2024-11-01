package lotto.util;

import static lotto.constants.ExceptionMessage.INVALID_INPUT;

public class Parser {
    public static int parseNumber(String stringValue) {
        int intValue;
        try {
            intValue = Integer.parseInt(stringValue);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.format());
        }
        return intValue;
    }
}