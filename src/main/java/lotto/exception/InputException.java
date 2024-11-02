package lotto.exception;

import lotto.exception.common.BaseException;
import lotto.exception.message.InputExceptionMessage;

public class InputException extends BaseException {

    public InputException(InputExceptionMessage message) {
        super(message);
    }

}
