package lotto.exception;

import static lotto.exception.message.ErrorMessage.ERROR_PREFIX;

import lotto.exception.message.LottoExceptionMessage;

public class LottoException extends IllegalArgumentException{
    public LottoException(LottoExceptionMessage errorMessage) {
        super(ERROR_PREFIX + errorMessage.getMessage());
    }
}