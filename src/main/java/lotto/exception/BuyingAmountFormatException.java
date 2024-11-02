package lotto.exception;

public class BuyingAmountFormatException extends BuyingAmountException {
    private static final String MESSAGE = "1000 이상 100000 이하의 양의 정수만 입력 가능합니다.";

    public BuyingAmountFormatException() {
        super(MESSAGE);
    }
}
