package lotto.view.input;

import static lotto.handler.InputHandler.INPUT_MONEY;

public class InputMoneyView extends InputView {
    @Override
    public String readInput() {
        return prompt(INPUT_MONEY);
    }
}
