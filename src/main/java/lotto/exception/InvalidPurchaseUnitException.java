package lotto.exception;

public class InvalidPurchaseUnitException extends IllegalArgumentException {

    public InvalidPurchaseUnitException() {
        super("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
    }
}