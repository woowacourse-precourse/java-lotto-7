package lotto.controller;

import lotto.view.InputPaymentView;

public class CheckingWinningLottoController {
    private InputPaymentView inputPaymentView;

    public CheckingWinningLottoController() {
        this.create();
    }

    public void create() {
        this.inputPaymentView = InputPaymentView.getInputView();

    }
}
