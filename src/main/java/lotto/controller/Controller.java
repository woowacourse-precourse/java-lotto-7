package lotto.controller;

import lotto.util.PurchaseAmountValidator;
import lotto.util.Validator;
import lotto.view.InputView;

public class Controller {

    private final Validator validator = new PurchaseAmountValidator();

    public void run() {
        String totalAmount = InputView.requestAmountToPurchase();
        validator.validate(totalAmount);
    }
}
