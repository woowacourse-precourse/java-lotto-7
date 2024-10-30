package lotto.infrastructure.exception;

public class CustomException extends IllegalArgumentException {
    public CustomException(String message) {
        super(String.format("[ERROR] %s", message));
    }
}
