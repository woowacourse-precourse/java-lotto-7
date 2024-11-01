package lotto.Exception;

public class NotANumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력 받았습니다.";

    public NotANumberException() {
        super(ERROR_MESSAGE);
    }
}
