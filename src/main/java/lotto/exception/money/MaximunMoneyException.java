package lotto.exception.money;

public class MaximunMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 100,000원까지만 구입 가능합니다.";

    public MaximunMoneyException() {
        super(ERROR_MESSAGE);
    }
}
