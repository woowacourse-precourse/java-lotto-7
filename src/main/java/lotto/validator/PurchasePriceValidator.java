package lotto.validator;

import static lotto.common.InputRule.LOTTO_PRICE;
import static lotto.parser.InputParser.parseInteger;
import static lotto.validator.ValidationMessage.INVALID_INPUT_FORMAT;
import static lotto.validator.ValidationMessage.INVALID_NEGATIVE_PRICE;
import static lotto.validator.ValidationMessage.INVALID_PURCHASE_PRICE;

import lotto.exception.InvalidInputException;

public class PurchasePriceValidator {

    public void validate(String inputPurchasePrice) {
        validInput(inputPurchasePrice);
        int purchasePrice = parseInteger(inputPurchasePrice);
        validPurchasePrice(purchasePrice);
        validDivisibleByLottoPrice(purchasePrice);
    }

    private void validInput(String inputPurchasePrice) {
        try {
            parseInteger(inputPurchasePrice);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_INPUT_FORMAT.getMessage());
        }
    }

    private void validPurchasePrice(int purchasePrice) {
        if (purchasePrice < 0) {
            throw new InvalidInputException(INVALID_NEGATIVE_PRICE.getMessage());
        }
    }

    private void validDivisibleByLottoPrice(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE.getValue() != 0) {
            throw new InvalidInputException(INVALID_PURCHASE_PRICE.getMessage());
        }
    }
}
