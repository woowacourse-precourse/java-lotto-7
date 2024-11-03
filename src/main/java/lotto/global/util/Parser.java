package lotto.global.util;

import static lotto.global.util.ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT;

public abstract class Parser {

    public static Integer parseToInt(String value) {
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT.getMessage());
        }
    }

}
