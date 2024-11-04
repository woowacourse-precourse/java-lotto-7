package lotto.util;

import lotto.exception.EmptyInputException;
import lotto.exception.NotNumberException;

import java.util.function.Supplier;

public class ValidateUtil {

    public static void emptyValue(final String value) {
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

    public static int parseToInt(final String value, Supplier<? extends Exception> exception) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException(exception.get());
        }
    }
}
