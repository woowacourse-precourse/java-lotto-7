package lotto.exception.Lotto;

public class NotSixNumbersException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 번호는 6개여야 합니다.";

    public NotSixNumbersException() {
        super(ERROR_MESSAGE);
    }
}
