package lotto.exception;

public class InputException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final InputError inputError;

    public InputException(InputError error) {
        super();
        this.inputError = error;
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + inputError.getMessage();
    }

}
