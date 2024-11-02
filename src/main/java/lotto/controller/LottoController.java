package lotto.controller;

import lotto.domain.Money;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        Money money = getMoney();
    }

    private Money getMoney() {
        while (true) {
            try {
                int moneyInput = inputView.inputMoney();
                return new Money(moneyInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
