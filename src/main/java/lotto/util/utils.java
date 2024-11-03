package lotto.util;

import static lotto.exception.ExceptionMessage.*;

public class utils {
    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
