package lotto.view.input;

import static lotto.handler.InputHandler.INPUT_BONUS_NUMBER;

public class InputBonusNumberView extends InputView {
    @Override
    public String readInput() {
        return prompt(INPUT_BONUS_NUMBER);
    }
}
