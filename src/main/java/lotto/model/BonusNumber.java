package lotto.model;

import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;

import lotto.exception.LottoValidationError;

public class BonusNumber {

    private final int number;

    public BonusNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public int value() {
        return number;
    }

    private void validate(final int number) {
        checkMinimumOfBonusNumber(number);
        checkMaximumOfBonusNumber(number);
    }

    private void checkMinimumOfBonusNumber(final int number) {
        if (number < MIN_LOTTO_NUMBER) {
            LottoValidationError.BONUS_NUMBER_BELOW_MINIMUM.throwException(MIN_LOTTO_NUMBER);
        }
    }

    private void checkMaximumOfBonusNumber(final int number) {
        if (number > MAX_LOTTO_NUMBER) {
            LottoValidationError.BONUS_NUMBER_ABOVE_MAXIMUM.throwException(MAX_LOTTO_NUMBER);
        }
    }
}
