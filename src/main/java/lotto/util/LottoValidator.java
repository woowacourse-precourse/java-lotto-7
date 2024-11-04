package lotto.util;

import lotto.service.LottoMachine;

public class LottoValidator {

    public static void validateNumberRange(int number) {
        if (number < LottoMachine.LOTTO_NUM_START || number > LottoMachine.LOTTO_NUM_END) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_OUT_OF_RANGE.getMsg());
        }
    }

}
