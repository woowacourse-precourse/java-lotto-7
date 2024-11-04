package lotto.controller;

import lotto.model.BonusNumber;
import lotto.util.IoComponent;

import static lotto.util.common.RepeatInput.repeatUntilValid;

public class BonusNumberController {
    private final IoComponent ioComponent;

    public BonusNumberController(IoComponent ioComponent) {
        this.ioComponent = ioComponent;
    }

    public BonusNumber createBonusNumber() {
        ioComponent.inputView().printRequestBonusNumber();
        return repeatUntilValid(this::requestBonusNumber, ioComponent.commonIo());
    }

    private BonusNumber requestBonusNumber() {
        String rawBonusNumber = ioComponent.ioController().inputBonusNumber();
        int bonusNumber = ioComponent.ioController().convertInputToInt(rawBonusNumber);
        return new BonusNumber(bonusNumber);
    }
}
