package lotto.exception;

import lotto.enums.ErrorCode;

public class FormatException extends NumberFormatException {

    public FormatException(ErrorCode errorCode) {
        super("[ERROR] " + errorCode.getMessage());
    }
}
