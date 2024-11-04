package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum InputExceptionMessage implements ExceptionMessage {

    INVALID_WINNING_NUMBERS("당첨 숫자는 ','를 기준으로 입력해주세요."),
    INVALID_PURCHASE_AMOUNT("올바른 금액 정보를 입력하세요."),
    INVALID_BONUS_NUMBER("올바른 보너스 번호 정보를 입력하세요."),
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
