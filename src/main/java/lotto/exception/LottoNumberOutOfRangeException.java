package lotto.exception;

import static lotto.constant.ExceptionMessageConstants.LOTTO_NUMBER_OUT_OF_RANGE_ERROR;

public class LottoNumberOutOfRangeException extends IllegalArgumentBaseException {

    public LottoNumberOutOfRangeException() {
        super(LOTTO_NUMBER_OUT_OF_RANGE_ERROR.getMessage());
    }
}
