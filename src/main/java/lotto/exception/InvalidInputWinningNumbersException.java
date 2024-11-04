package lotto.exception;

public class InvalidInputWinningNumbersException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호 입력 형식이 잘못되었습니다.";

    public InvalidInputWinningNumbersException() {
        super(ERROR_MESSAGE);
    }
}
