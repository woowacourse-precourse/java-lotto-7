package lotto.handler.purchase.validation;

import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class PurchaseInputRangeValidator implements PurchaseInputValidator {
    @Override
    public void validate(HandlerToken handlerToken) {
        int purchaseAmount = getPurchaseAmountToInteger(handlerToken);
        if (!isInRange(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASING_RANGE_ERROR.getErrorMessage());
        }
    }

    private boolean isInRange(int purchaseAmount) {
        return (purchaseAmount >= 1000) && (purchaseAmount <= 100000);
    }
}
