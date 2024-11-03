package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;

public class LottoController {
    private final Output output;
    private final Input input;

    public LottoController(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    public void playLotto() {
        handlePurchasePrice();
    }

    private void handlePurchasePrice() {
        output.printPurchasePriceInputPrompt();
        String purchasePrice = input.inputString();
    }
}
