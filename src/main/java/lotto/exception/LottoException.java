package lotto.exception;

import static lotto.constant.error.LottoErrorConstants.PREFIX_ERROR_MESSAGE;

public class LottoException extends IllegalArgumentException {

    public LottoException(ErrorCode errorCode) {
        super(PREFIX_ERROR_MESSAGE + errorCode.getMessage());
    }
}
