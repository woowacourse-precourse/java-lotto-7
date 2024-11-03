package lotto.validator;

import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class PurchaseAmountValidator implements NumberValidator {

    @Override
    public int validate(String purchaseAmountInput) {
        if (purchaseAmountInput == null || purchaseAmountInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY.getMessage());
        }

        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            if (purchaseAmount <= LottoConstants.ZERO) {
                throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
            }
            if (purchaseAmount % LottoConstants.TICKET_PRICE != LottoConstants.ZERO) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DISABLE_BY_1000.getMessage());
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }
}
