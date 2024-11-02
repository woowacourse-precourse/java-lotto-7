package lotto.dto;

import lotto.exception.CustomIllegalArgumentException;

import static lotto.exception.ErrorMessage.*;

public record PurchaseTotalPriceInput(String amount) {

    public PurchaseTotalPriceInput {
        validate(amount);
    }

    private void validate(String amount) {
        validatePurchaseAmountNotNull(amount);
        validatePurchaseAmountNotEmpty(amount);
    }

    private void validatePurchaseAmountNotNull(String amount) {
        if (amount == null) {
            throw CustomIllegalArgumentException.from(NULL_INPUT);
        }
    }

    private void validatePurchaseAmountNotEmpty(String amount) {
        if (amount.isEmpty()) {
            throw CustomIllegalArgumentException.from(EMPTY_INPUT);
        }
    }
}
