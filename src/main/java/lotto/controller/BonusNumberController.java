package lotto.controller;

import lotto.service.BonusNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumberController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BonusNumberService bonusNumberService;

    public BonusNumberController(InputView inputView, OutputView outputView, BonusNumberService bonusNumberService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bonusNumberService = bonusNumberService;
    }

    public void run() {
        while (true) {
            try {
                inputView.printBonusNumberInput();
                bonusNumberService.save(inputView.getInput());
                outputView.printEmptyLine();

                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
