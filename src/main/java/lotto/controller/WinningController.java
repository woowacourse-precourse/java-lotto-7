package lotto.controller;

import lotto.purchasing.view.InputPaymentView;

public class WinningController {
    private InputPaymentView inputPaymentView;

    public WinningController() {
        this.create();
    }

    public void create() {
        this.inputPaymentView = InputPaymentView.getInputView();

    }
}
