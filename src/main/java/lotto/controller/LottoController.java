package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    public void play() {
        input();
    }

    public void input() {
        InputView inputView = new InputView();
        String purchaseMoney = inputView.InputPurchaseMoney();
    }
}
