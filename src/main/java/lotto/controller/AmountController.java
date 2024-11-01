package lotto.controller;

import lotto.validation.AmountValidation;
import lotto.view.InputView;

public class AmountController {

    private final InputView inputView;

    public AmountController() {
        this.inputView = new InputView();
    }

    public int inputAmount() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        AmountValidation.amountValidation(purchaseAmount);
        int amount = Integer.parseInt(purchaseAmount);
        return amount;
    }

}
