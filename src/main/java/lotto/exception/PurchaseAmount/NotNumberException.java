package lotto.exception.PurchaseAmount;

public class NotNumberException extends IllegalArgumentException {
    private static final String errorMessage = "금액은 숫자를 입력해야 합니다.";

    public NotNumberException() {
        super(errorMessage);
    }
}
