package lotto.exception;

public class InvalidInputMoneyFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액 입력 형식이 잘못되었습니다.";

    public InvalidInputMoneyFormatException() {
        super(ERROR_MESSAGE);
    }
}
