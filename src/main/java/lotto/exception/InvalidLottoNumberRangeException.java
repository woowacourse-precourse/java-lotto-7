package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {
    public InvalidLottoNumberRangeException() {
        super(LottoErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
    }
}
