package lotto.exception;

public class InvalidLottoNumberException extends IllegalArgumentException {
    public InvalidLottoNumberException(String message) {
        super("[ERROR] " + message);
    }
}