package lotto.exception;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException(ErrorMessages errorMessages) {
        super(errorMessages.getMessage());
    }
}
