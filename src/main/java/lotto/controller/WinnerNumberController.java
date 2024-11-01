package lotto.controller;

import lotto.service.WinnerNumberService;
import lotto.view.InputView;

public class WinnerNumberController {

    private final InputView inputView;
    private final WinnerNumberService winnerNumberService;

    public WinnerNumberController(InputView inputView, WinnerNumberService winnerNumberService) {
        this.inputView = inputView;
        this.winnerNumberService = winnerNumberService;
    }

    public void run() {
        inputView.printWinnerNumberInput();
        winnerNumberService.validate(inputView.getInput());
    }
}
