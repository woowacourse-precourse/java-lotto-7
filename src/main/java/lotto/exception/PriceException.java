package lotto.exception;

import lotto.exception.message.Error;
import lotto.exception.model.LottoExceptionBase;

public class PriceException extends LottoExceptionBase {

    public PriceException(int num) {
        super(Error.REMAIN_EXISTS.formatMessageOf(num));
    }
}
