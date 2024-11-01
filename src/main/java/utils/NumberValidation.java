package utils;

import static exception.ErrorMessage.NUMBER_RANGE_ERROR;

import java.util.List;

public class NumberValidation {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private NumberValidation() {
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
        }
    }

}
