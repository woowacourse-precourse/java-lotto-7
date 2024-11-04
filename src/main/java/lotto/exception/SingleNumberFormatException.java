package lotto.exception;

public class SingleNumberFormatException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 양의 정수가 아닌 다른 값이 입력되었습니다.";

    public SingleNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
