package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {

    InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Money money = inputView.getMoney();

    }
}
