package lotto.controller;

import lotto.util.PurchaseAmountValidator;
import lotto.util.Validator;
import lotto.view.InputView;

import java.util.List;

public class Controller {

    private final Validator validator = new PurchaseAmountValidator();

    public void run() {
        while (true) {
            String totalAmount = InputView.requestAmountToPurchase();
            try {
                validator.validate(totalAmount);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            String input = InputView.requestJackpotNumbers();

            try {

                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
