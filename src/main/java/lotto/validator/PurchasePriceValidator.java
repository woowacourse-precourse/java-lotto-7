package lotto.validator;

import static lotto.parser.InputParser.parseInteger;
import static lotto.validator.ValidationMessage.INVALID_PURCHASE_PRICE_FORMAT;

import lotto.exception.InvalidInputException;

public class PurchasePriceValidator {
    public void validate(String inputPurchasePrice) {
        validateNotNull(inputPurchasePrice);
        validateNotEmpty(inputPurchasePrice);
        validateIsInteger(inputPurchasePrice);
    }

    private void validateNotNull(String inputPurchasePrice) {
        if (inputPurchasePrice == null) {
            throw new InvalidInputException(INVALID_PURCHASE_PRICE_FORMAT.getMessage());
        }
    }

    private void validateNotEmpty(String inputPurchasePrice) {
        if (inputPurchasePrice.isEmpty() || inputPurchasePrice.isBlank()) {
            throw new InvalidInputException(INVALID_PURCHASE_PRICE_FORMAT.getMessage());
        }
    }

    private void validateIsInteger(String inputPurchasePrice) {
        try {
            parseInteger(inputPurchasePrice);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_PURCHASE_PRICE_FORMAT.getMessage());
        }
    }
}
