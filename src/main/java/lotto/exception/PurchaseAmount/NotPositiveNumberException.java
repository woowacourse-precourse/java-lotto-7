package lotto.exception.PurchaseAmount;

public class NotPositiveNumberException extends IllegalArgumentException {
    private static final String errorMessage = "올바른 금액을 입력해야 합니다.";

    public NotPositiveNumberException() {
        super(errorMessage);
    }
}
