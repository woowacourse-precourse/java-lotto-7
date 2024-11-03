package lotto.exception;

public class InputNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";

    public InputNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
