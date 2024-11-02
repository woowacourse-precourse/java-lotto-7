package lotto.exception;

import static lotto.constant.ExceptionMessageConstants.DUPLICATE_LOTTO_NUMBER_ERROR;

public class DuplicateLottoNumberException extends IllegalArgumentBaseException {

    public DuplicateLottoNumberException() {
        super(DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
    }
}
