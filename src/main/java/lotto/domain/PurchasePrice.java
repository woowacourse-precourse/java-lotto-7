package lotto.domain;

import lotto.exception.IllegalPriceDivideException;
import lotto.exception.IllegalPriceNumberException;

public record PurchasePrice(
        int value
) {

    public static final int DIVIDE_UNIT = 1000;

    public static PurchasePrice validatePrice(String originPrice) {
        int price = validatePriceInteger(originPrice);
        if (price % DIVIDE_UNIT != 0) {
            throw new IllegalPriceDivideException();
        }
        return new PurchasePrice(price);
    }

    private static int validatePriceInteger(String originPrice) {
        try {
            return Integer.parseInt(originPrice);
        } catch (NumberFormatException e) {
            throw new IllegalPriceNumberException();
        }
    }
}
