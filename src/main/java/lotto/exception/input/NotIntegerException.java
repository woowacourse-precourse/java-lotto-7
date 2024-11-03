package lotto.exception.input;

public class NotIntegerException extends NumberFormatException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자를 입력해야합니다.";
    public NotIntegerException() {
        super(ERROR_MESSAGE);
    }
}
