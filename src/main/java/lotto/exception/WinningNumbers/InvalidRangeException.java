package lotto.exception.WinningNumbers;

public class InvalidRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "1부터 45까지 범위의 숫자를 입력해야 합니다.";

    public InvalidRangeException() {
        super(ERROR_MESSAGE);
    }
}
