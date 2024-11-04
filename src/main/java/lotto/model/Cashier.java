package lotto.model;

import static lotto.utils.Constants.LOTTO_PRICE;

import lotto.utils.ErrorMessage;

public class Cashier {
    private int price;

    public Cashier() {
        this.price = 0;
    }

    public void payPrice(int price) {
        validatePriceAmount(price);
        this.price = price;
    }

    public int getLottoCount() {
        return (this.price / LOTTO_PRICE);
    }

    public int getPrice() {
        return price;
    }

    private void validatePriceAmount(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_THOUSAND_UNITS.getMessage());
        }
    }
}
