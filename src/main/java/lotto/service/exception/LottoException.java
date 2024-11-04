package lotto.service.exception;

import lotto.exception.BaseException;
import lotto.exception.ExceptionMessage;

public class LottoException extends BaseException {

    public LottoException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
