package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.JackpotNumbersValidator;
import lotto.util.PurchaseAmountValidator;
import lotto.util.StringParser;
import lotto.util.Validator;
import lotto.view.InputView;

import java.util.List;

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
                List<Integer> intList = StringParser.toIntList(inputJackpotNumbers);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

    }
}
