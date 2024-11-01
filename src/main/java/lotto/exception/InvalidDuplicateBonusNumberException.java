package lotto.exception;

public class InvalidDuplicateBonusNumberException extends IllegalArgumentException{
    public InvalidDuplicateBonusNumberException(String message) {
        super(message);
    }
}
