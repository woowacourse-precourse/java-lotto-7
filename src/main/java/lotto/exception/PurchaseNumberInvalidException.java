package lotto.exception;

public class PurchaseNumberInvalidException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "구매 금액은 숫자어야합니다.";

    public PurchaseNumberInvalidException() {
        super(DEFAULT_MESSAGE);
    }
}
