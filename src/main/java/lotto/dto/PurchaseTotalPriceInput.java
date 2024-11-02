package lotto.dto;

import lotto.exception.CustomIllegalArgumentException;

import static lotto.exception.ErrorMessage.*;

public record PurchaseTotalPriceInput(String totalPrice) {

    public PurchaseTotalPriceInput {
        validate(totalPrice);
    }

    private void validate(String totalPrice) {
        validateTotalPriceNotNull(totalPrice);
        validateTotalPriceNotEmpty(totalPrice);
    }

    private void validateTotalPriceNotNull(String totalPrice) {
        if (totalPrice == null) {
            throw CustomIllegalArgumentException.from(NULL_INPUT);
        }
    }

    private void validateTotalPriceNotEmpty(String totalPrice) {
        if (totalPrice.isEmpty()) {
            throw CustomIllegalArgumentException.from(EMPTY_INPUT);
        }
    }
}
