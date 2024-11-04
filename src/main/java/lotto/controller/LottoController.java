package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void run() {
        issue();
    }

    private void issue() {
        int cost = Integer.parseInt(InputView.requestCost());
    }
}
