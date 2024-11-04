package lotto.exception.paper;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_UNIT;

public class PurchaseAmountUnitException extends IllegalArgumentException{
    public PurchaseAmountUnitException() {
        super(PURCHASE_AMOUNT_UNIT.getMessage());
    }
}
