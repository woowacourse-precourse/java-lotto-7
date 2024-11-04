package lotto.exception;

public class InvalidInputMoneyDivideException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 1000원 단위로 입력해야 합니다.";

    public InvalidInputMoneyDivideException() {
        super(ERROR_MESSAGE);
    }
}
