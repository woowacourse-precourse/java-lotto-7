package lotto.view.input;

import static lotto.handler.InputHandler.INPUT_WINNING_NUMBERS;

public class InputWinningNumbersView extends InputView {
    @Override
    public String readInput() {
        return prompt(INPUT_WINNING_NUMBERS);
    }
}
