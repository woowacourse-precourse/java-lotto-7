package lotto.controller;

import lotto.model.BonusNumber;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;

import static lotto.util.RepeatInput.repeatUntilValid;

public class BonusNumberController {
    private final InputView inputView;
    private final IoController ioController;
    private final CommonIo commonIo;

    public BonusNumberController(InputView inputView, IoController ioController, CommonIo commonIo) {
        this.inputView = inputView;
        this.ioController = ioController;
        this.commonIo = commonIo;
    }

    public BonusNumber createBonusNumber() {
        inputView.printRequestBonusNumber();
        return repeatUntilValid(this::requestBonusNumber, commonIo);
    }

    private BonusNumber requestBonusNumber() {
        String rawBonusNumber = ioController.inputBonusNumber();
        int bonusNumber = ioController.convertInputToInt(rawBonusNumber);
        return new BonusNumber(bonusNumber);
    }
}
