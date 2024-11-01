package lotto.exception;

public class PurchaseAmountTypeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자로 입력해주셔야 합니다";

    public PurchaseAmountTypeException() {
        super(ERROR_MESSAGE);
    }
}
