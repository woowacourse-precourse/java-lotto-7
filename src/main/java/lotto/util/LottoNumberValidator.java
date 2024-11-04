package lotto.util;

import static lotto.constant.ErrorMessages.INVALID_LOTTO_NUMBER_ERROR;
import static lotto.constant.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

public class LottoNumberValidator {

    private LottoNumberValidator() {
    }

    public static void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR);
        }
    }
}
