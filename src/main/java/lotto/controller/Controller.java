package lotto.controller;

import lotto.util.JackpotNumbersValidator;
import lotto.util.PurchaseAmountValidator;
import lotto.util.Validator;
import lotto.view.InputView;

public class Controller {

    private final Validator validator = new PurchaseAmountValidator();
    private final Validator jackpotNumbersValidator = new JackpotNumbersValidator();
    public void run() {
        while (true) {
            String inputTotalAmount = InputView.requestAmountToPurchase();
            try {
                validator.validate(inputTotalAmount);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            String inputJackpotNumbers = InputView.requestJackpotNumbers();
            try {
                jackpotNumbersValidator.validate(inputJackpotNumbers);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
