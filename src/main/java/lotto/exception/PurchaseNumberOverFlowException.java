package lotto.exception;

public class PurchaseNumberOverFlowException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "구매 금액은 2,147,483,000원 이하여야 합니다.";

    public PurchaseNumberOverFlowException() {
        super(DEFAULT_MESSAGE);
    }
}
