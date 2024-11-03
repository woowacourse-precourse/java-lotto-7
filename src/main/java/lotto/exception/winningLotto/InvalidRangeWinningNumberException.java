package lotto.exception.winningLotto;

public class InvalidRangeWinningNumberException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 정수여야 합니다.";

    public InvalidRangeWinningNumberException() {
        super(ERROR_MESSAGE);

    }
}
