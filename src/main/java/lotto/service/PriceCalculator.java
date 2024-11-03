package lotto.service;

import lotto.validation.InputValidator;

public class PriceCalculator {

    private final InputValidator inputValidator;

    public PriceCalculator() {
        this.inputValidator = new InputValidator();
    }

    public void calculateLotto(String input) {
        parsePrice(input);

    }

    private void parsePrice(String input) {
        validatePrice(input);
        int price = Integer.parseInt(input);
    }

    private void validatePrice(String input){
        inputValidator.validatePurchasePrice(input);;
    }

}
