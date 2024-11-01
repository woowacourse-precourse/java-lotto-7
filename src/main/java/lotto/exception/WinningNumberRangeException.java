package lotto.exception;

public class WinningNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 1~45 사이에 포함되어야 합니다";

    public WinningNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
