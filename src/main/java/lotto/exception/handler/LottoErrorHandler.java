package lotto.exception.handler;

import lotto.exception.BaseErrorCode;
import lotto.exception.GeneralException;

public class LottoErrorHandler extends GeneralException {
    public LottoErrorHandler(BaseErrorCode code) {
        super(code);
    }
}
