package lotto.view.util;

import static lotto.exception.ExceptionMessage.INVALID_NUMBER_FORMAT;

public class NumberParser {
    public Integer parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
