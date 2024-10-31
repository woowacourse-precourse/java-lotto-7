package lotto;

import java.util.Collections;
import java.util.List;

public class Validator {

    public static void validateDuplicate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_EXIST_EXCEPTION.getMessage());
            }
        }
    }

    public static void validatedNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_COUNT_EXCEPTION.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION.getMessage());
            }
        }
    }
}
