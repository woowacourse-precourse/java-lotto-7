package lotto.model;

import lotto.exceptions.StateException;

public class Quantity {
    private final int quantity;

    private Quantity(int quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    public static Quantity from(Money money) {
        return new Quantity(divide(money));
    }

    private static int divide(Money money) {
        return money.getSum() / Money.LOTTO_PRICE;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validate(int quantity) {
        if (quantity > 0) {
            throw StateException.INVALID_QUANTITY;
        }
    }
}
