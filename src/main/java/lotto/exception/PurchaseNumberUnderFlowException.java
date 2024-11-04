package lotto.exception;

public class PurchaseNumberUnderFlowException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "구매 금액은 1,000 이상이여야 합니다.";

    public PurchaseNumberUnderFlowException() {
        super(DEFAULT_MESSAGE);
    }
}
