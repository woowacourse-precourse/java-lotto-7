package lotto.handler.purchase.validation;

import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class PurchaseInputFormatValidator implements PurchaseInputValidator {
    @Override
    public void validate(HandlerToken handlerToken) {
        try {
            Integer.parseInt(getPurchaseAmountToString(handlerToken));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASING_FORMAT_ERROR.getErrorMessage());
        }
    }
}
