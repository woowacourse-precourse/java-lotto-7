package lotto.controller;

import lotto.model.BonusNumber;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;

public class BonusNumberController {
    private final InputView inputView;
    private final IoController ioController;

    public BonusNumberController() {
        CommonIo commonIo = new CommonIo();
        this.inputView = new InputView(commonIo);
        this.ioController = new IoController(commonIo);
    }

    public BonusNumber createBonusNumber(){
        inputView.printRequestBonusNumber();
        String rawBonusNumber = ioController.inputBonusNumber();
        int bonusNumber = ioController.convertInputToInt(rawBonusNumber);
        return new BonusNumber(bonusNumber);
    }

}
