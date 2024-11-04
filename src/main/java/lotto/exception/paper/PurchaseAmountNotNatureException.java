package lotto.exception.paper;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_NOT_NATURE;

public class PurchaseAmountNotNatureException extends IllegalArgumentException{
    public PurchaseAmountNotNatureException() {
        super(PURCHASE_AMOUNT_NOT_NATURE.getMessage());
    }
}
