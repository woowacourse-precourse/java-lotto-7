package lotto.exception;

import static lotto.constant.ExceptionMessageConstants.LOTTO_NUMBER_COUNT_ERROR;

public class LottoNumberCountException extends  IllegalArgumentBaseException {

    public LottoNumberCountException() {
        super(LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }
}
