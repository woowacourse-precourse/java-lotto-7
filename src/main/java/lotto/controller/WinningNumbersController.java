package lotto.controller;

import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;

public class WinningNumbersController {

    public void getWinningNumbers() {
        String input = InputView.inputWinningNumbers();
        WinningNumbersValidator.validate(input);
    }
}
