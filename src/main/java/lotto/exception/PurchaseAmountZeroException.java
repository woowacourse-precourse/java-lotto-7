package lotto.exception;

public class PurchaseAmountZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액은 0원 이상이어야 합니다";

    public PurchaseAmountZeroException() {
        super(ERROR_MESSAGE);
    }
}
