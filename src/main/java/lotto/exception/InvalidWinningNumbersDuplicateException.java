package lotto.exception;

public class InvalidWinningNumbersDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";

    public InvalidWinningNumbersDuplicateException() {
        super(ERROR_MESSAGE);
    }
}