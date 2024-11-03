package lotto.handler.purchase.validation;

import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class PurchaseInputUnitValidator implements PurchaseInputValidator {
    @Override
    public void validate(HandlerToken handlerToken) {
        int purchaseAmount = getPurchaseAmountToInteger(handlerToken);

        if (!isUnitsOfThousand(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASING_UNIT_ERROR.getErrorMessage());
        }
    }

    private boolean isUnitsOfThousand(int purchaseAmount) {
        return (purchaseAmount % 1000) == 0;
    }
}
