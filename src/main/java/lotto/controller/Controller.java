package lotto.controller;

import lotto.constants.ErrorConstants;
import lotto.util.PurchaseAmountValidator;
import lotto.util.Validator;
import lotto.view.InputView;

public class Controller {

    private final Validator validator = new PurchaseAmountValidator();

    public void run() {
        while (true) {
            String totalAmount = InputView.requestAmountToPurchase();
            try {
                validator.validate(totalAmount);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
