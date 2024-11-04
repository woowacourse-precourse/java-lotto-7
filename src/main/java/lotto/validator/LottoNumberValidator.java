package lotto.validator;

import lotto.utils.LottoException;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER_RANGE;
import static lotto.constants.LottoValue.MIN_LOTTO_NUMBER_RANGE;

public class LottoNumberValidator {

    private LottoNumberValidator() {
    }

    public static void validateLottoNumber(final int number) {
        if (number < MIN_LOTTO_NUMBER_RANGE.getValue() || number > MAX_LOTTO_NUMBER_RANGE.getValue()) {
            throw new LottoException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }
}
