package lotto.exception.handler;

import lotto.exception.BaseErrorCode;
import lotto.exception.GeneralException;

public class WinningNumberErrorHandler extends GeneralException {
    public WinningNumberErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
