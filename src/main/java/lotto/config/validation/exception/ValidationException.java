package lotto.config.validation.exception;

public class ValidationException extends IllegalArgumentException {

    public ValidationException(String message) {
        super("[ERROR] " + message);
    }
}
