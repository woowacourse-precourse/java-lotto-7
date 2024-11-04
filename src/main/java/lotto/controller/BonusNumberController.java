package lotto.controller;

import lotto.model.BonusNumber;
import lotto.temp.IoComponent;

import static lotto.util.RepeatInput.repeatUntilValid;

public class BonusNumberController {
    private final IoComponent ioComponent;

    public BonusNumberController(IoComponent ioComponent) {
        this.ioComponent = ioComponent;
    }

    public BonusNumber createBonusNumber() {
        ioComponent.getInputView().printRequestBonusNumber();
        return repeatUntilValid(this::requestBonusNumber, ioComponent.getCommonIo());
    }

    private BonusNumber requestBonusNumber() {
        String rawBonusNumber = ioComponent.getIoController().inputBonusNumber();
        int bonusNumber = ioComponent.getIoController().convertInputToInt(rawBonusNumber);
        return new BonusNumber(bonusNumber);
    }
}
