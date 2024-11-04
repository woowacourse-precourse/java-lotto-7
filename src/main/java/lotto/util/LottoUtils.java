package lotto.util;

import static lotto.constant.LottoConstants.*;
import static lotto.exception.ExceptionMessage.*;

public class LottoUtils {
    public static void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
