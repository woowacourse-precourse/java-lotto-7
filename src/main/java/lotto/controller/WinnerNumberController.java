package lotto.controller;

import lotto.service.WinnerNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinnerNumberController {

    private final InputView inputView;
    private final OutputView outputView;
    private final WinnerNumberService winnerNumberService;

    public WinnerNumberController(InputView inputView, OutputView outputView, WinnerNumberService winnerNumberService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winnerNumberService = winnerNumberService;
    }

    public void run() {
        while (true) {
            try {
                inputView.printWinnerNumberInput();
                winnerNumberService.save(inputView.getInput());
                outputView.printEmptyLine();

                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
