package lotto.util;

import lotto.domain.Lotto;

public class LottoValidator {

    public static void validateNumberRange(int number) {
        if (number < Lotto.LOTTO_NUM_START || number > Lotto.LOTTO_NUM_END) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_OUT_OF_RANGE.getMsg());
        }
    }

}
