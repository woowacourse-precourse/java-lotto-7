package lotto.exception;

public class PurchaseNumberUnitException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "구매 금액은 1,000원 단위어야 합니다.";

    public PurchaseNumberUnitException() {
        super(DEFAULT_MESSAGE);
    }
}
