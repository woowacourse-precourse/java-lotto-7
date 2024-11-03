package lotto.service;

import lotto.validation.LottoPurchaseValidator;

public class PriceCalculator {

    private final LottoPurchaseValidator lottoPurchaseValidator;

    public PriceCalculator() {
        this.lottoPurchaseValidator = new LottoPurchaseValidator();
    }

    public void calculateLotto(String input) {
        parsePrice(input);

    }

    private void parsePrice(String input) {
        validatePrice(input);
        int price = Integer.parseInt(input);
    }

    private void validatePrice(String input){
        lottoPurchaseValidator.validatePurchasePrice(input);;
    }

}
