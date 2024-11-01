package lotto.controller;

import lotto.service.BonusNumberService;
import lotto.view.InputView;

public class BonusNumberController {

    private final InputView inputView;
    private final BonusNumberService bonusNumberService;

    public BonusNumberController(InputView inputView, BonusNumberService bonusNumberService) {
        this.inputView = inputView;
        this.bonusNumberService = bonusNumberService;
    }

    public void run() {
        inputView.printBonusNumberInput();
        bonusNumberService.validate(inputView.getInput());
    }
}
