package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum WinningNumberExceptionMessage implements ExceptionMessage {

    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨번호와 같을 수 없습니다.");

    private final String message;

    WinningNumberExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
