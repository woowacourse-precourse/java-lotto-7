package lotto.model;

import lotto.util.InputValidator;
import lotto.util.message.ErrorMessage;

public class InputParser {
    public int parsePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            InputValidator.validateNonNegativeAmount(purchaseAmount);
            InputValidator.validateAmountUnit(purchaseAmount);
            return divideByThousand(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    private int divideByThousand(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
