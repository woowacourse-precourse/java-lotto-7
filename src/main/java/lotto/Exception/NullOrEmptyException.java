package lotto.Exception;

public class NullOrEmptyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 빈 값을 입력 받았습니다.";

    public NullOrEmptyException() {
        super(ERROR_MESSAGE);
    }
}
