package lotto.dto.input;

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
            throw new NullPointerException(NULL_INPUT.getMessage());
        }
    }

    private void validateTotalPriceNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }
}
