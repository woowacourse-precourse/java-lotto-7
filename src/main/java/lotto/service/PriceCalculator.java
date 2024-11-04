package lotto.service;

import lotto.validation.LottoPurchaseValidator;

public class PriceCalculator {

    private final LottoPurchaseValidator lottoPurchaseValidator;

    public PriceCalculator() {
        this.lottoPurchaseValidator = new LottoPurchaseValidator();
    }

    public int calculateLotto(int price) {
        return price / 1000;
    }

    public int parsePrice(String input) {
        validatePrice(input);
        return Integer.parseInt(input);
    }

    private void validatePrice(String input){
        lottoPurchaseValidator.validate(input);;
    }
}
