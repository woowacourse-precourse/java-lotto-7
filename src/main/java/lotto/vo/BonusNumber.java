package lotto.vo;

import static lotto.config.LottoInfo.MAXIMUM_LOTTO_NUMBER;
import static lotto.config.LottoInfo.MINIMUM_LOTTO_NUMBER;

import lotto.exception.LottoException.LottoNumberOutOfRangeException;

public record BonusNumber(Integer number) {

    public BonusNumber {
        validateBonusNumber(number);
    }

    private void validateBonusNumber(final Integer number) {
        if (isLessThenMinimumNumber(number) && isOverThenMaximumNumber(number)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private boolean isLessThenMinimumNumber(final Integer number) {
        return number < MINIMUM_LOTTO_NUMBER.getValue();
    }

    private boolean isOverThenMaximumNumber(final Integer number) {
        return number > MAXIMUM_LOTTO_NUMBER.getValue();
    }
}
