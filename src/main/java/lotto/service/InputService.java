package lotto.service;

import lotto.util.Validator;
import lotto.view.InputView;
import java.math.BigInteger;

public class InputService {
    public BigInteger getPurchaseMoney() {
        InputView inputView = new InputView();
        Validator validator = new Validator();

        while (true) {
            try {
                return validator.validPurchaseMoney(inputView.readPurchaseMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
