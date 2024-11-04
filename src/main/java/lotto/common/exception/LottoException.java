package lotto.common.exception;

import lotto.common.constant.LottoErrorCode;

public class LottoException extends IllegalArgumentException {
    private final LottoErrorCode errorCode;

    public LottoException(LottoErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}