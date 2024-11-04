package lotto.utils;

import static lotto.constant.ErrorMessage.*;

public class Parser {

    public static Integer parse(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INCLUDE_CHARACTER_ERROR.getMessage());
        }
    }
}
