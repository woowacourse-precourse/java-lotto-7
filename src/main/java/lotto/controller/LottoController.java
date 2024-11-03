package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;
import lotto.util.Validator;

public class LottoController {
    private final Output output;
    private final Input input;
    private final Validator validator;

    public LottoController(Output output, Input input, Validator validator) {
        this.output = output;
        this.input = input;
        this.validator = validator;
    }

    public void playLotto() {
        handlePurchasePrice();
    }

    private void handlePurchasePrice() {
        output.printPurchasePriceInputPrompt();
        String purchasePrice = input.inputString();

        validatePurchasePriceInput(purchasePrice);
    }

    private void validatePurchasePriceInput(String input) {
        validator.validateEmptyInput(input);
        validator.validateNonNumber(input);
    }
}
