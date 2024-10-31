package lotto.exception;

import lotto.message.ErrorMessage;

public final class BlankMessageException extends IllegalArgumentException {
    public BlankMessageException() {
        super(ErrorMessage.Blank_Message.getErrorMessage());
    }
}
