package lotto.domain;

import lotto.util.Converter;
import lotto.validation.PriceValidator;

public class PurchasePrice {

    private final long price;

    public PurchasePrice(String price) {
        PriceValidator.validatePrice(price);
        this.price = Converter.convertStringToLong(price);
    }

    public long getPrice() {
        return price;
    }

    public int calculatePurchaseCount() {
        return (int) (price / 1000);
    }
}