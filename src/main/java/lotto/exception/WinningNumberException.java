package lotto.exception;

public class WinningNumberException extends IllegalArgumentException {
    public WinningNumberException(ErrorMessages errorMessages) {
        super(errorMessages.getMessage());
    }
}
