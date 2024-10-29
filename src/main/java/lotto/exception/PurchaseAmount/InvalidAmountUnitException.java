package lotto.exception.PurchaseAmount;

public class InvalidAmountUnitException extends IllegalArgumentException {
    private static final String errorMessage = "1,000단위 금액을 입력해야 합니다.";

    public InvalidAmountUnitException() {
        super(errorMessage);
    }
}
