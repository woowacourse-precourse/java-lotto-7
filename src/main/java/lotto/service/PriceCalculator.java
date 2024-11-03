package lotto.service;

import lotto.validation.LottoPurchaseValidator;

public class PriceCalculator {

    private final LottoPurchaseValidator lottoPurchaseValidator;

    public PriceCalculator() {
        this.lottoPurchaseValidator = new LottoPurchaseValidator();
    }

    public int calculateLotto(String input) {
        int price = parsePrice(input);
        return price / 1000;
    }

    private int parsePrice(String input) {
        validatePrice(input);
        return Integer.parseInt(input);
    }

    private void validatePrice(String input){
        lottoPurchaseValidator.validatePurchasePrice(input);;
    }

}
