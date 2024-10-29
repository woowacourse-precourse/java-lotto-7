package lotto.common.exception;

import lotto.common.constant.LottoConst;

public enum ErrorCode {

    // input
    NOT_NUMBER(LottoConst.NOT_NUMBER_MSG),
    CANT_DIVIDE(LottoConst.CANT_DIVIDE_MSG);

    private final String message;

    ErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return LottoConst.ERROR_PREFIX + message;
    }
}
