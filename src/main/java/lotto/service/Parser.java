package lotto.service;

import static lotto.util.ExceptionMessage.INVALID_INPUT;

public class Parser {
    public static int toInt(String stringValue) {
        int intValue;
        try {
            intValue = Integer.parseInt(stringValue);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.format());
        }
        return intValue;
    }
}