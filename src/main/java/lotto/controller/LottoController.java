package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        OutputView.printPurChaseAmountInputMessage();
        String s = InputView.readInput();
        System.out.println(s);
    }
}
