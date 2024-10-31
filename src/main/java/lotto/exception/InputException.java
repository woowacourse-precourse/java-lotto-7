package lotto.exception;

public class InputException extends IllegalArgumentException{
    public InputException(final ExceptionMessage message) {
        super(message.getMessage());
    }
}
