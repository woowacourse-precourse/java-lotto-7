package lotto.exception.number;

import lotto.exception.ErrorCode;

public enum NumberErrorCode implements ErrorCode {
    INVALID_NUMBER_RANGE("숫자는 1부터 45사이여야 합니다.");

    private final String message;

    NumberErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
