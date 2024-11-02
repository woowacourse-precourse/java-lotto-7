package lotto.exception;

import lotto.exception.message.Error;
import lotto.exception.model.LottoExceptionBase;

public class LottoNumberException extends LottoExceptionBase {

    public LottoNumberException(Error error) {
        super(error.getMessage());
    }
}
