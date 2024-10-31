package lotto.exception;

public class BuyingAmountException extends IllegalArgumentException {
    private static final String HEADER = "[ERROR] 로또 구입 금액 입력이 올바르지 않습니다. ";

    public BuyingAmountException(String message) {
        super(HEADER + message);
    }
}
