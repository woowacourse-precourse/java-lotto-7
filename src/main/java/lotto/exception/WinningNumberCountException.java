package lotto.exception;

public class WinningNumberCountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개가 입력되어야 합니다";

    public WinningNumberCountException() {
        super(ERROR_MESSAGE);
    }
}
