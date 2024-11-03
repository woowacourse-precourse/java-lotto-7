package lotto.global.exception;

import lotto.global.enums.ExceptionMessage;

public class InvalidBonusNumberException extends IllegalArgumentException {
    public InvalidBonusNumberException() {
        super(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
    }
}
