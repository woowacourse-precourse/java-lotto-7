package lotto.exception;

public class InvalidDuplicateNumberException extends IllegalArgumentException{
    public InvalidDuplicateNumberException(String message) {
        super(message);
    }
}
