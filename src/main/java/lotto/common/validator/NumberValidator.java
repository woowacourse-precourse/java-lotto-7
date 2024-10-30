package lotto.common.validator;

import lotto.error.NumberErrorMessage;
import java.util.regex.Pattern;

public class NumberValidator {
    private static final String NUMBER_CHECK_REGEX = "^[0-9]+$";

    public static void validate(String number) {
        checkNumber(number);
        checkRange(Integer.parseInt(number));
    }

    private static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NumberErrorMessage.NOT_ALLOWED_NUMBER
                    .getMessage());
        }
    }

    protected static void checkNumber(String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.IS_NOT_NUMBER
                    .getMessage());
        }
    }

    private static boolean isNumber(String number) {
        return Pattern.matches(NUMBER_CHECK_REGEX, number);
    }
}
