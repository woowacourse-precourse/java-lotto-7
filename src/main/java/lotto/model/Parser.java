package lotto.model;

import static lotto.constant.message.ErrorMessage.*;

public class Parser {

    public static Integer parseInputToInt(String input) {
        String trimmedInput = trimWhitespace(input);
        return convertStringToInteger(trimmedInput);
    }

    private static String trimWhitespace(String input) {
        return input.trim();
    }

    private static Integer convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }
}
