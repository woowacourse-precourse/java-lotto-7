package lotto.exception;

public class CannotDividedInThousandException extends BuyingAmountException {
    private static final String MESSAGE = "1000원 단위로만 구매 가능합니다.";

    public CannotDividedInThousandException() {
        super(MESSAGE);
    }
}
