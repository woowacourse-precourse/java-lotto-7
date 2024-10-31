package lotto.controller.validator;

import static lotto.exception.InvalidAmountException.INVALID_AMOUNT_MESSAGE;

import lotto.exception.InvalidAmountException;
import lotto.util.LottoConstants;

public class PurchaseAmountValidator {
    private final int amount;

    public PurchaseAmountValidator(int amount) {
        this.amount = amount;
    }

    public void validate() {
        if (amount % LottoConstants.LOTTO_PURCHASE_AMOUNT != 0) {
            throw new InvalidAmountException(INVALID_AMOUNT_MESSAGE);
        }
    }
}
