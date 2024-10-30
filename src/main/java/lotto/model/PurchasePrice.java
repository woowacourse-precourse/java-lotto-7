package lotto.model;

import lotto.util.validator.PurchasePriceValidator;

public class PurchasePrice {
    private final int price;

    public PurchasePrice(int price) {
        PurchasePriceValidator.validatePurchasePrice(price);
        this.price = price;
    }

    public int get() {
        return price;
    }
}
