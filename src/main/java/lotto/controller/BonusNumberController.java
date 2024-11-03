package lotto.controller;

import lotto.model.BonusNumber;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;

import java.util.function.Supplier;

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

        int bonusNumber = repeatUntilValid(() -> {
            String rawBonusNumber = ioController.inputBonusNumber();
            return ioController.convertInputToInt(rawBonusNumber);
        });

        return new BonusNumber(bonusNumber);
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            commonIo.printMessage(illegalArgumentException.getMessage());
            return repeatUntilValid(function);
        }
    }

}
