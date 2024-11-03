package lotto.utils.parser;

import static lotto.exception.ErrorMessage.*;

public class BonusNumberInputParser {

    public static int parse(String input) {
        return convertToInteger(input);
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INTEGER.getMessage());
        }
    }
}
