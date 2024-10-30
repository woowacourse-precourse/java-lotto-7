package lotto.controller;

import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumbersController {

    public void getWinningNumbers() {
        try {
            String input = InputView.inputWinningNumbers();
            WinningNumbersValidator.validate(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getWinningNumbers();
        }
    }
}
