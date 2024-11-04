package lotto.service.exception;

import lotto.exception.ExceptionMessage;

public enum LottoExceptionMessage implements ExceptionMessage {

    ;

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
