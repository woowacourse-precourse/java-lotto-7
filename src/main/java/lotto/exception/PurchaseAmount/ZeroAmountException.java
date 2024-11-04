package lotto.exception.PurchaseAmount;

public class ZeroAmountException extends IllegalArgumentException {
    private static final String errorMessage = "0보다 큰 금액을 입력해야 합니다.";

    public ZeroAmountException() {
        super(errorMessage);
    }
}
