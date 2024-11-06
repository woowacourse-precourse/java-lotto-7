package lotto.exception;

public class WinningNumberDuplicationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다";

    public WinningNumberDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
