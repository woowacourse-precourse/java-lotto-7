package lotto.exception;

import lotto.enums.ErrorCode;

public class CommonException extends IllegalArgumentException {

    public CommonException(ErrorCode errorCode) {
        super("[ERROR] " + errorCode.getMessage());
    }
}