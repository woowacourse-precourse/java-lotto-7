package lotto.utils;

import lotto.constants.ErrorMessages;

public class NumberValidator {


    public static void validateNumberRange(Integer number, int max, int min) {
        if (exceedRange(number, max, min)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static boolean exceedRange(Integer number, int max, int min) {
        return number > max || number < min;
    }

    public static void validateInt(String input) {
        if (!isInt(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DIGIT.getMessage());
        }
    }

    private static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
