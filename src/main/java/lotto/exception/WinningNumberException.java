package lotto.exception;

import lotto.exception.common.BaseException;
import lotto.exception.message.WinningNumberExceptionMessage;

public class WinningNumberException extends BaseException {

    public WinningNumberException(WinningNumberExceptionMessage message) {
        super(message);
    }

}
