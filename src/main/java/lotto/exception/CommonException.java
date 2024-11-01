package lotto.exception;

import lotto.enums.ErrorCode;

public class CommonException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public CommonException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return this.errorCode.getMessage();
    }
}
