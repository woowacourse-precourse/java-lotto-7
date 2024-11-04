package lotto.exception;

public class InvalidWinningNumbersSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";

    public InvalidWinningNumbersSizeException() {
        super(ERROR_MESSAGE);
    }
}
