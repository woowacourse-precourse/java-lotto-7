package lotto.exception;

public class BuyingAmountFormatException extends BuyingAmountException {
    private static final String MESSAGE = "숫자만 입력 가능합니다.";

    public BuyingAmountFormatException() {
        super(MESSAGE);
    }
}
