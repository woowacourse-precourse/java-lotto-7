package lotto.util;

import static lotto.exception.ExceptionMessage.*;

public class LottoUtils {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
