package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidBonusNumberFormatException extends IllegalArgumentException {
    public InvalidBonusNumberFormatException() {
        super(LottoErrorMessage.LOTTO_BONUS_NUMBER_FORMAT_ERROR);
    }
}
