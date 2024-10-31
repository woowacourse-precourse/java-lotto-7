package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    public void run() {
        String paidAmount = InputView.getPaidAmount();
        InputValidator.validatePaidAmount(paidAmount);
    }
}
