package lotto.controller;

import lotto.view.InputView;

public class WinnerNumberController {

    private final InputView inputView;

    public WinnerNumberController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.printWinnerNumberInput();
        inputView.getInput();
    }
}
