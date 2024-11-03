package lotto.exception;

import static lotto.constant.ExceptionMessageConstants.LOTTO_NUMBER_FORMAT_ERROR;

public class LottoNumberFormatException extends  IllegalArgumentBaseException {

    public LottoNumberFormatException() {
        super(LOTTO_NUMBER_FORMAT_ERROR.getMessage());
    }
}
