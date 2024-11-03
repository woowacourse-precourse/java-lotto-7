package lotto.Exception.Money;

import lotto.Exception.ExceptionCode;

public enum MoneyInputErrorCode implements ExceptionCode {
    NOT_IN_THOUSANDS("금액은 %d원 단위로 입력해야 합니다.");

    private final String message;

    MoneyInputErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
