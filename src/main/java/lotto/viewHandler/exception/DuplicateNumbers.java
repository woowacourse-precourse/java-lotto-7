package lotto.viewHandler.exception;

public class DuplicateNumbers extends MyException {
    public DuplicateNumbers() {
        super();
    }

    public DuplicateNumbers(String message) {
        super(message);
    }

    public DuplicateNumbers(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateNumbers(Throwable cause) {
        super(cause);
    }

}
