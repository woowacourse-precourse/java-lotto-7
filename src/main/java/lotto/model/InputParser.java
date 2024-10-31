package lotto.model;

import lotto.util.InputValidator;
import lotto.util.message.ErrorMessage;

public class InputParser {
    public int parsePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            InputValidator.validateNonNegativeAmount(purchaseAmount);
            InputValidator.validateAmountUnit(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }
}
