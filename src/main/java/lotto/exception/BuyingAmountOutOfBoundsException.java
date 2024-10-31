package lotto.exception;

public class BuyingAmountOutOfBoundsException extends BuyingAmountException {
    private static final String MESSAGE = "1000원 이상 10만원 이하로만 구입 가능합니다.";

    public BuyingAmountOutOfBoundsException() {
        super(MESSAGE);
    }
}
