package lotto.exception;

import lotto.exception.message.Error;
import lotto.exception.model.LottoExceptionBase;

public class LottoNumberException extends LottoExceptionBase {

    public LottoNumberException(Error error) {
        super(error.getMessage());
    }

    public LottoNumberException(int minimum, int maximum) {
        super(Error.INVALID_RANGE.formatMessageOf(minimum, maximum));
    }
}
