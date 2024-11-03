package lotto.handler.purchase.validation;

import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class PurchaseInputFormatValidator implements PurchaseInputValidator {
    private static final String VALID_REGULAR_EXPRESSION = "^[0-9]+$";

    @Override
    public void validate(HandlerToken handlerToken) {
        String purchaseAmount = getPurchaseAmountToString(handlerToken);
        if (!hasOnlyNumeric(purchaseAmount)) {
            throw new NumberFormatException(ErrorMessage.INVALID_PURCHASING_FORMAT_ERROR.getErrorMessage());
        }
    }

    private boolean hasOnlyNumeric(String purchaseAmount) {
        return purchaseAmount.matches(VALID_REGULAR_EXPRESSION);
    }
}
