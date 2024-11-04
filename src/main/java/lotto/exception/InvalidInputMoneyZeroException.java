package lotto.exception;

public class InvalidInputMoneyZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 0보다 커야 합니다.";

    public InvalidInputMoneyZeroException() {
        super(ERROR_MESSAGE);
    }
}
