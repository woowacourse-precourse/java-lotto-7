package lotto.view.input;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException(InputErrorMessage inputError) {
        super(inputError.message);
    }
}
