package lotto.model.validator;

import lotto.exception.Exception;
import java.util.List;

public class NumberRangeValidator {

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException(
                        Exception.INVALID_NUMBER_RANGE.getMessage()
                );
            }
        }
    }

    public static void validateNumberRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(
                    Exception.INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
