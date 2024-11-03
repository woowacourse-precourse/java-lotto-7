package lotto.controller;

import lotto.model.BonusNumber;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;

import static lotto.util.RepeatInput.repeatUntilValid;

public class BonusNumberController {
    private final InputView inputView;
    private final IoController ioController;
    private final CommonIo commonIo = new CommonIo();

    public BonusNumberController() {
        this.inputView = new InputView(commonIo);
        this.ioController = new IoController(commonIo);
    }

    public BonusNumber createBonusNumber() {
        inputView.printRequestBonusNumber();

        return repeatUntilValid(() -> {
            String rawBonusNumber = ioController.inputBonusNumber();
            int bonusNumber = ioController.convertInputToInt(rawBonusNumber);
            return new BonusNumber(bonusNumber);
        },commonIo);

    }
}
