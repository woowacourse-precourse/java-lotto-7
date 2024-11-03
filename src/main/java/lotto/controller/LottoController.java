package lotto.controller;

import lotto.dto.Purchase;
import lotto.util.Validator;
import lotto.view.InputView;

import java.math.BigInteger;

public class LottoController {
    public void play() {
        input();
    }

    private void input() {
        InputView inputView = new InputView();
        Validator validator = new Validator();

        Purchase purchase = new Purchase(getPurchaseMoney(inputView, validator));
    }

    private BigInteger getPurchaseMoney(InputView inputView, Validator validator) {
        while (true) {
            try {
                return validator.validPurchaseMoney(inputView.InputPurchaseMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
