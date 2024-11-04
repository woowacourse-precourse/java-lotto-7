package lotto.service;

import lotto.validation.LottoPurchaseValidator;

public class PriceCalculator {

    private static final int LOTTO_PRICE = 1000;

    private final LottoPurchaseValidator lottoPurchaseValidator;

    public PriceCalculator() {
        this.lottoPurchaseValidator = new LottoPurchaseValidator();
    }

    public int calculateLotto(int price) {
        return price / LOTTO_PRICE;
    }

    public int parsePrice(String input) {
        validatePrice(input);
        return Integer.parseInt(input);
    }

    private void validatePrice(String input){
        lottoPurchaseValidator.validate(input);
    }
}
