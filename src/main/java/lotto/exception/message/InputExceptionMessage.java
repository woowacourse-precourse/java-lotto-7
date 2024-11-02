package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum InputExceptionMessage implements ExceptionMessage {

    INVALID_INTEGER_FORMAT("-2147483648 ~ 2147483647 사이의 숫자 값만 입력하세요."),
    INVALID_BIG_DECIMAL_FORMAT("올바른 숫자 정보를 입력하세요."),
    ;

    private final String message;

    InputExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
