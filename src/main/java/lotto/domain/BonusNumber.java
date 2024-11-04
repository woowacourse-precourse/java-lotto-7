package lotto.domain;

import static lotto.constant.Constant.NUMBERS_RANGE_END;
import static lotto.constant.Constant.NUMBERS_RANGE_START;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        validateRange();
    }

    private void validateRange() {
        if (bonusNumber < NUMBERS_RANGE_START || bonusNumber > NUMBERS_RANGE_END) {
            throw new LottoException(ExceptionCode.OUT_OF_RANGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
