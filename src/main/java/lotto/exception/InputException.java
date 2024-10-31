package lotto.exception;

import lotto.global.ErrorCode;

public class InputException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public InputException(ErrorCode errorCode) {
        System.out.println(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
