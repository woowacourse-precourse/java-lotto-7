package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum LottoNumberExceptionMessage implements ExceptionMessage {

    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ;

    private final String message;

    LottoNumberExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
