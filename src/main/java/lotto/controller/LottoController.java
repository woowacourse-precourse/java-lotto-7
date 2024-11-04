package lotto.controller;

import lotto.view.UserInput;

public class LottoController {
    private final UserInput userInput;

    public LottoController() {
        this.userInput = new UserInput();
    }

    public void process() {
        int amount = userInput.getPurchaseAmount();
    }
}
