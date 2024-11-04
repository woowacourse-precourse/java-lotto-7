package lotto.exception;

public class InvalidLottoPurchaseAmountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 구매 금액은 1000원 단위로 입력해야 합니다.";

    public InvalidLottoPurchaseAmountException() {
        super(ERROR_MESSAGE);
    }
}
