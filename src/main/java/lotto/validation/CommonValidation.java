package lotto.validation;

import lotto.enumValue.ExceptionMessage;

public class CommonValidation {
    public static String isEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_EMPTY.getErrorDescription());
        }

        return value.strip();
    }

    public static int isIntegerType(String value) {
        try {
            return Integer.parseInt(value.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INTEGER_VALUE.getErrorDescription());
        }
    }

    public static void value1to45(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_1_TO_45.getErrorDescription());
        }
    }
}
