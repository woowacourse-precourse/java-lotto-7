package lotto.domain;

import lotto.ExceptionMessage;

public record PurchasePrice(
        int value
) {

    public static PurchasePrice validatePrice(String originPrice) {
        int price = validatePriceInteger(originPrice);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PRICE_DIVIDE_EXCEPTION.getMessage());
        }
        return new PurchasePrice(price);
    }

    private static int validatePriceInteger(String originPrice) {
        try {
            return Integer.parseInt(originPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.PRICE_NUMBER_EXCEPTION.getMessage());
        }
    }
}
