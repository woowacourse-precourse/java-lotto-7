package lotto.exception.message;

import lotto.exception.common.ExceptionMessage;

public enum WinningNumberExceptionMessage implements ExceptionMessage {

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
