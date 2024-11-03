package lotto.exception;

public class InvalidBonusNumberException extends IllegalArgumentException {
    public InvalidBonusNumberException(String message) {
        super("[ERROR] " + message);
    }
}