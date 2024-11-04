package lotto.utils;

import lotto.error.ErrorStatus;

public class StringParser {

    public static int parseStringToInt(String input) {
        int parsedInput = parseInteger(input);
        return parsedInput;
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_INPUT_INTEGER.getMessage());
        }
    }

}
