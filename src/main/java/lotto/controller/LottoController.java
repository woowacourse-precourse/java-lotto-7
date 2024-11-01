package lotto.controller;

import static lotto.view.Prompt.BONUS_NUMBER;
import static lotto.view.Prompt.PURCHASE_AMOUNT;
import static lotto.view.Prompt.WINNING_NUMBERS;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        OutputView.displayPrompt(PURCHASE_AMOUNT);
        InputView.getInput();

        OutputView.displayPrompt(WINNING_NUMBERS);
        InputView.getInput();

        OutputView.displayPrompt(BONUS_NUMBER);
        InputView.getInput();
    }
}
