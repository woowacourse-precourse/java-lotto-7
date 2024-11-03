package lotto.dto.input;

import lotto.exception.CustomIllegalArgumentException;

import static lotto.exception.ErrorMessage.*;

public record PurchaseTotalPriceInput(String input) {

    public PurchaseTotalPriceInput {
        validate(input);
    }

    private void validate(String input) {
        validateTotalPriceNotNull(input);
        validateTotalPriceNotEmpty(input);
    }

    private void validateTotalPriceNotNull(String input) {
        if (input == null) {
            throw CustomIllegalArgumentException.from(NULL_INPUT);
        }
    }

    private void validateTotalPriceNotEmpty(String input) {
        if (input.isEmpty()) {
            throw CustomIllegalArgumentException.from(EMPTY_INPUT);
        }
    }
}
