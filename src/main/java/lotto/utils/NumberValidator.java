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
}
