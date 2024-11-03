package lotto.common;

import static lotto.common.Exceptions.NOT_POSITIVE_INTEGER;

public class Converter {
    public static int toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER.getMessage());
        }
    }
}
