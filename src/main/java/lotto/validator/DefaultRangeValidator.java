package lotto.validator;

import static lotto.constant.ErrorCode.INVALID_NUMBER_RANGE;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

public class DefaultRangeValidator implements RangeValidator {

    @Override
    public void validateNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
