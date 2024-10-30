package lotto.exception;

import lotto.exception.common.BaseException;
import lotto.exception.message.LottoExceptionMessage;

public class LottoException extends BaseException {

    public LottoException(LottoExceptionMessage message) {
        super(message);
    }

}
