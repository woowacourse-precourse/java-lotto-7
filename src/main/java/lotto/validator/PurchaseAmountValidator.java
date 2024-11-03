package lotto.validator;

import lotto.config.LottoConfig;
import lotto.view.message.ErrorMessage;

public class PurchaseAmountValidator {
    public static int validate(String input) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateIsNumeric(input);

        int purchaseAmount = Integer.parseInt(input);
        InputValidator.validateIsPositive(purchaseAmount);
        validatePrice(purchaseAmount);

        return purchaseAmount;
    }

    private static void validatePrice(int purchaseAmount) {
        if (purchaseAmount % LottoConfig.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PRICE_UNITS.getMessage());
        }
    }
}
