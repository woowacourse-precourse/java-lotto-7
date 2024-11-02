package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum LottoMoneyExceptionMessage implements ExceptionMessage {

    INVALID_MONEY_UNIT("금액은 1000원 단위로 입력해야 합니다."),
    INVALID_MONEY_AMOUNT("금액은 1000원 이상 입력해야 합니다."),
    INVALID_MAX_MONEY("최대 입력 금액을 초과했습니다.")
    ;

    private final String message;

    LottoMoneyExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
