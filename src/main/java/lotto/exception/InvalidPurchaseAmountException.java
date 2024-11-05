package lotto.exception;

public class InvalidPurchaseAmountException extends IllegalArgumentException {

    public InvalidPurchaseAmountException() {
        super("[ERROR] 구입금액은 1,000원 이상이어야 합니다.");
    }
}