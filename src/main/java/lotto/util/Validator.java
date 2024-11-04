package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.common.ErrorMessage.*;

public class Validator {
    public static void checkIntegerRange(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(INTEGER_RANGE_EXCESS.getMessage());
        }
    }
}
