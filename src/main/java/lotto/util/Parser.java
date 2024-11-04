package lotto.util;

import lotto.exception.InputNumberFormatException;

public class Parser {
    private Parser() {}

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InputNumberFormatException();
        }
    }

    public static String[] stringToArray(String input) {
        return input.trim().split(",");
    }
}
