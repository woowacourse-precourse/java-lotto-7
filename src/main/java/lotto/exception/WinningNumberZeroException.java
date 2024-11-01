package lotto.exception;

public class WinningNumberZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 0이상 이어야 합니다";

    public WinningNumberZeroException() {
        super(ERROR_MESSAGE);
    }
}
