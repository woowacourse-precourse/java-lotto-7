package lotto.exception;

public class WinningNumbersException extends IllegalArgumentException {
    private static final String HEADER = "[ERROR] 당첨 번호 입력이 올바르지 않습니다. ";

    public WinningNumbersException(String message) {
        super(HEADER + message);
    }
}
