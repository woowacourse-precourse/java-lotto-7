package lotto.exception;

public class ApplicationException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final ApplicationError error;

    public ApplicationException(ApplicationError error) {
        super();
        this.error = error;
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + this.error.getMessage();
    }
}
