package lotto.validate;

import static lotto.constants.Constants.*;

public class PriceValidate {

    private final int price;

    public PriceValidate(String priceString) {
        int price= toNumber(priceString);
        isPositiveNumber(price);
        validatePrice(price);

        this.price = price;
    }

    private int toNumber(String priceString) {
        try {
            return Integer.parseInt(priceString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + PRICE_NOT_NUMBER);
        }
    }

    private void isPositiveNumber(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ERROR + PRICE_NOT_POSITIVE_NUMBER);
        }
    }

    private void validatePrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR + PRICE_NOT_SUITABLE);
        }
    }

    public int getPrice() {
        return price;
    }
}
