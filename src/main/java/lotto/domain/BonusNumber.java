package lotto.domain;

import lotto.constants.Constants;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < Constants.LOTTO_MIN_NUMBER.getValue()
                || bonusNumber > Constants.LOTTO_MAX_NUMBER.getValue()) {
            throw LottoException.from(ErrorMessage.BONUS_NUMBER_RANGE_ERROR);
        }
    }
}
