package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum InputExceptionMessage implements ExceptionMessage {

    INVALID_NUMBER_FORMAT("숫자로만 입력해주세요. ex)1000");

    private final String message;

    InputExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
