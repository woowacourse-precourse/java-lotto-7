package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        int thousandUnitCount = inputView.readPurchaseAmount();
        outputView.printUnitCount(thousandUnitCount);
    }
}
