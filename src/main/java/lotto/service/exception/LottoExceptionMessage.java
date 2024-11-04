package lotto.service.exception;

import lotto.exception.ExceptionMessage;

public enum LottoExceptionMessage implements ExceptionMessage {

    // 당첨 번호
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호는 1 이상 45 이하의 숫자 6개를 콤마로 구분하여 입력해야 합니다."),
    // 보너스 번호
    BONUS_NUMBER_DUPLICATED("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다."),
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
