package lotto.utils;

import static lotto.utils.Constants.MAX_BOUND;
import static lotto.utils.Constants.MIN_BOUND;

public class LottoNumberValidator {

    public static boolean isWithinRange(int number) {
        return number >= MIN_BOUND && number <= MAX_BOUND;
    }
}
