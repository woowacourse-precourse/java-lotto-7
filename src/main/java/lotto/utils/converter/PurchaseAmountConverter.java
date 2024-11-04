package lotto.utils.converter;

import lotto.utils.ErrorMessages;

public class PurchaseAmountConverter {
    private PurchaseAmountConverter() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int convert(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_INTEGER_PURCHASE_AMOUNT);
        }
    }
}
