package lotto.exception;

public class PurchaseAmountFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위로 입력해주셔야 합니다";

    public PurchaseAmountFormatException() {
        super(ERROR_MESSAGE);
    }
}
