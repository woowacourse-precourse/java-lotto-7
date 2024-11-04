package lotto.exception.handler;

import lotto.exception.BaseErrorCode;
import lotto.exception.GeneralException;

public class MoneyErrorHandler extends GeneralException {
    public MoneyErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
