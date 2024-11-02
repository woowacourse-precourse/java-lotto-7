package lotto;

import static lotto.ExceptionMessages.INVALID_INPUT;

public class Parser {
    private static final String DIGIT_REGEX = "^[0-9]+$";
    public static Integer toInteger(String value) {
        if (!value.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        return Integer.parseInt(value);
    }
}
