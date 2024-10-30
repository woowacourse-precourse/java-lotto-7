package lotto.exception;

import lotto.exception.common.BaseException;
import lotto.exception.message.TicketExceptionMessage;

public class TicketException extends BaseException {

    public TicketException(TicketExceptionMessage message) {
        super(message);
    }

}
