package lotto.exception;

import lotto.exception.message.Error;
import lotto.exception.model.LottoExceptionBase;

public class LottoSizeException extends LottoExceptionBase {

    public LottoSizeException(int size) {
        super(Error.NOT_FIX_SIZE.formatMessageOf(size));
    }
}
