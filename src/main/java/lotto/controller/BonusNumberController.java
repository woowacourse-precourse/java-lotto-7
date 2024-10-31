package lotto.controller;

import lotto.validator.BonusNumberValidator;
import lotto.view.InputView;

public class BonusNumberController {

    public void getBonusNumber() {
        String input = InputView.inputBonusNumber();
        BonusNumberValidator.validate(input);
    }
}
