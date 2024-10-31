package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String money = inputView.getMoney();
    }
}
