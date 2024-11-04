package lotto.dto;

import lotto.validation.Validator;

public class BuyingPrice {
    private final static int LOTTO_PRICE = 1000;
    private final int price;

    public BuyingPrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        Validator.validateNegativeNumber(price);
        Validator.validateMultiplier(price, LOTTO_PRICE);
    }

    public int getLottoCount() {
        return price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }
}
