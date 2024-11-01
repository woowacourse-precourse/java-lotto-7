package lotto.model.exception;

import lotto.exception.CustomException;

public final class PurchaseMoneyInvalidException extends IllegalArgumentException implements CustomException {

    private PurchaseMoneyInvalidException(String message) {
        super(message);
    }

    public static IllegalArgumentException lottoMoneyTooSmall() {
        return new PurchaseMoneyInvalidException("로또 구매 금액은 1000원 이상이어야 합니다.");
    }

    public static IllegalArgumentException lottoMoneyNotDivisible() {
        return new PurchaseMoneyInvalidException("로또 구매 금액은 1000원 단위여야 합니다.");
    }
}
