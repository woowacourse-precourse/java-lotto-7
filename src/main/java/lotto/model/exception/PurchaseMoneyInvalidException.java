package lotto.model.exception;

import lotto.exception.CustomException;

public final class PurchaseMoneyInvalidException extends IllegalArgumentException implements CustomException {

    private PurchaseMoneyInvalidException(String message) {
        super(message);
    }

    public static IllegalArgumentException lottoMoneyTooSmall(String... details) {
        String message = CustomException.appendDetails("로또 구매 금액이 너무 작습니다.", details);
        return new PurchaseMoneyInvalidException(message);
    }

    public static IllegalArgumentException lottoMoneyNotDivisible(String... details) {
        String message = CustomException.appendDetails("로또 구매 금액의 단위가 맞지 않습니다.", details);
        return new PurchaseMoneyInvalidException(message);
    }
}
