package lotto.model;

import static lotto.constant.message.ErrorMessage.*;

public class Parser {

    public static Integer parseInputToInt(String input) {
        return convertStringToInteger(input);
    }

    private static Integer convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }
}
