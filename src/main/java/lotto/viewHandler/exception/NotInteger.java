package lotto.viewHandler.exception;

public class NotInteger extends MyException {
    public NotInteger() {
        super();
    }

    public NotInteger(String message) {
        super(message);
    }

    public NotInteger(String message, Throwable cause) {
        super(message, cause);
    }

    public NotInteger(Throwable cause) {
        super(cause);
    }

    public NotInteger(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
