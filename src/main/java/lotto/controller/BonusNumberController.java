package lotto.controller;

import lotto.view.InputView;

public class BonusNumberController {

    public void getBonusNumber() {
        String input = InputView.inputBonusNumber();
        System.out.println(input);
    }
}
