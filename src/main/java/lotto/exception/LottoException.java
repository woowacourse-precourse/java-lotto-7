package lotto.exception;

import lotto.message.ExceptionMessage;

public class LottoException extends IllegalArgumentException {

    public LottoException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
