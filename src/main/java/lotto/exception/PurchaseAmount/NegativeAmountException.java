package lotto.exception.PurchaseAmount;

public class NegativeAmountException extends IllegalArgumentException {
    private static final String errorMessage = "금액은 양수를 입력해야 합니다.";

    public NegativeAmountException() {
        super(errorMessage);
    }
}
