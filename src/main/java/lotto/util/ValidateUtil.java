package lotto.util;

import lotto.exception.EmptyInputException;
import lotto.exception.NotNumberException;

public class ValidateUtil {

    public static void emptyValue(String value) {
        if(value == null || value.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    public static void validateNumber(final String value) {
        ValidateUtil.emptyValue(value);
        if (!value.matches("\\d+")) {
            throw new NotNumberException();
        }
    }
}
