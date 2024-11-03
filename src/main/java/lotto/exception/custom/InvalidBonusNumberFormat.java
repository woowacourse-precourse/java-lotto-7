package lotto.exception.custom;

import lotto.exception.LottoException;

import static lotto.exception.ErrorCode.INVALID_BONUS_NUMBER_FORMAT;

public class InvalidBonusNumberFormat extends LottoException {

    public InvalidBonusNumberFormat() {
        super(INVALID_BONUS_NUMBER_FORMAT.getMessage());
    }
}
