package lotto.util;

import lotto.ErrorMessage;

public class LottoValidator {

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_OUT_OF_RANGE.getMsg());
        }
    }

}
