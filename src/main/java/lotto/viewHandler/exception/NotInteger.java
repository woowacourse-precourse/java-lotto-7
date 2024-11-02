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
}
