package lotto.exception;

public class WinningNumberTypeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 숫자가 입력되어야 합니다";

    public WinningNumberTypeException() {
        super(ERROR_MESSAGE);
    }
}
