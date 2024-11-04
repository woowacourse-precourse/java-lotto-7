package lotto.exception.handler;

import lotto.exception.BaseErrorCode;
import lotto.exception.GeneralException;

public class ParseErrorHandler extends GeneralException {
    public ParseErrorHandler(BaseErrorCode code) {
        super(code);
    }
}
