package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class PurchaseAmountValidator {

    public static void validateMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_NUMBER.getMessage());
        }
    }
}