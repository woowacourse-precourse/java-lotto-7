package lotto.controller;

import lotto.validator.BonusNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumberController {

    public void getBonusNumber() {
        try {
            String input = InputView.inputBonusNumber();
            BonusNumberValidator.validate(input);
        }catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getBonusNumber();
        }
    }
}
