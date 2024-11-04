package lotto.exception.WinningNumbers;

public class InvalidNumberCountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "당첨 번호는 6자리를 입력해야 합니다.";

    public InvalidNumberCountException() {
        super(ERROR_MESSAGE);
    }
}
