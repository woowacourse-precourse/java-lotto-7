package lotto.controller;

import lotto.view.InputView;

public class InputController {
    private InputView inputView = new InputView();
    private AmountValidator amountValidator = new AmountValidator();

    public Integer initPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = inputView.enterPurchaseAmount();
                return amountValidator.validate(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
