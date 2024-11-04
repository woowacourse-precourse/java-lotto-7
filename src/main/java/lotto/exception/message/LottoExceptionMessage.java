package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum LottoExceptionMessage implements ExceptionMessage {

    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_COUNT("로또 번호는 중복을 제외한 6개의 숫자로 구성되어야 합니다."),
    ;

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
