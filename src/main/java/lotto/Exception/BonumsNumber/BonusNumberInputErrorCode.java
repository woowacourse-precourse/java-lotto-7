package lotto.Exception.BonumsNumber;

import lotto.Exception.ExceptionCode;

public enum BonusNumberInputErrorCode implements ExceptionCode {
    INCORRECT_BONUS_COUNT("보너스 번호는 1개여야 합니다.");

    private final String message;

    BonusNumberInputErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

