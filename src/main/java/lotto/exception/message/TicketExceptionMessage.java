package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum TicketExceptionMessage implements ExceptionMessage {

    INVALID_MONEY_UNIT("금액은 1000원 단위로 입력해야 합니다."),
    INVALID_MONEY_AMOUNT("최소 1000원 이상 입력해야 합니다.");

    private final String message;

    TicketExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
