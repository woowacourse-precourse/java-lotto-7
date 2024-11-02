package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Money money;

    public void run() {
        inputLottoPurchaseMoney();
    }

    private void inputLottoPurchaseMoney() {
        while (true) {
            try {
                String rawInput = InputView.inputLottoPurchaseMoney();
                money = new Money(rawInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.outputErrorMessage(e);
            }
        }
    }

}
