package lotto.exception;

import lotto.message.ErrorMessage;

public final class DuplicateBonusNumberException extends IllegalArgumentException {
    public DuplicateBonusNumberException() {
        super(ErrorMessage.BONUS_NUMBER_DUPLICATE.getErrorMessage());
    }
}
