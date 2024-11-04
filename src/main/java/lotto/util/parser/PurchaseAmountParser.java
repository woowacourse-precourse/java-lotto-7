package lotto.util.parser;

import static lotto.message.ErrorMessage.EMPTY_INPUT_PURCHASE_AMOUNT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.NOT_INTEGER_RANGE_INPUT_ERROR_MESSAGE;

public class PurchaseAmountParser {

    public static int parseRawPurchaseAmount(String rawPurchaseAmount) {
        validateNotEmptyString(rawPurchaseAmount);

        try {
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_RANGE_INPUT_ERROR_MESSAGE.getContent());
        }
    }

    private static void validateNotEmptyString(String rawPurchaseAmount) {
        if (rawPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_PURCHASE_AMOUNT_ERROR_MESSAGE.getContent());
        }
    }
}
