package lotto.controller;

import lotto.validation.AmountValidation;
import lotto.view.InputView;
import lotto.view.OutputErrorView;

public class AmountController {

    private final InputView inputView;
    private final OutputErrorView outputErrorView;

    public AmountController() {
        this.inputView = new InputView();
        this.outputErrorView = new OutputErrorView();
    }

    public int inputAmount() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        try {
            AmountValidation.amountValidation(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputErrorView.errorMessage(e);
            inputAmount();
        }
        int amount = Integer.parseInt(purchaseAmount);
        return amount;
    }

}
