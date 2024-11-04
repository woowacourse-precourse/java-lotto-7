package lotto.validator;

import static lotto.constant.ErrorCode.INVALID_NUMBER_RANGE;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import lotto.view.OutputView;

public class DefaultRangeValidator implements RangeValidator {

    @Override
    public void validateNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            OutputView.printError(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
