package lotto.service;

import lotto.util.Validator;
import lotto.view.InputView;
import java.math.BigInteger;
import java.util.List;

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

    public List<BigInteger> getWinningNumbers() {
        InputView inputView = new InputView();
        Validator validator = new Validator();

        while (true) {
            try {
                return validator.validWinningNumbers(inputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BigInteger getBonusNumber() {
        InputView inputView = new InputView();
        Validator validator = new Validator();

        while (true) {
            try {
                return validator.validBonusNumber(inputView.readBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
