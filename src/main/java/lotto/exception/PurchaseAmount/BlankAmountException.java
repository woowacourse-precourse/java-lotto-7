package lotto.exception.PurchaseAmount;

public class BlankAmountException extends IllegalArgumentException {
    private static final String errorMessage = "금액을 입력해야 합니다.";

    public BlankAmountException() {
        super(errorMessage);
    }
}
