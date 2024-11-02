package lotto.validators;

import lotto.models.constants.LottoValues;
import lotto.validators.constants.ErrorMessages;

public class PurchaseAmountValidator implements NumberInputValidator {
    public boolean isValid(String input) {
        try {
            checkInputType(input);
            checkDivisibility(input);
            checkValueRange(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void checkDivisibility(String input) {
        int amount = Integer.parseInt(input);
        if (amount % LottoValues.TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_DIVISIBLE.getMessage());
        }
    }

    public void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < LottoValues.TICKET_PRICE.getValue() || amount > LottoValues.PURCHASE_CAP.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_AMOUNT_NOT_WITHIN_RANGE.getMessage());
        }
    }
}
